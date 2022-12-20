package com.itender.security;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itender.filter.CustomAuthenticationFilter;
import com.itender.filter.CustomAuthorizationFilter;
import com.itender.model.Role;
import com.itender.model.UserApp;
import com.itender.repository.UserRepository;
import com.itender.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final Environment environment;
    private final UserRepository userRepository;
    private static final String SUPER_ADMIN_ROLE = "ROLE_SUPER_ADMIN";
    private static final String COMMERCE_ADMIN_ROLE = "ROLE_COMMERCE_ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(
                authenticationManagerBean(), environment, userRepository);
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http.cors();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        setSuperAdminAuthorizations(http);
        setCommerceAdminAuthorizations(http);
        setDefaultAuthorization(http);
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(environment), UsernamePasswordAuthenticationFilter.class);
    }

    private void setDefaultAuthorization(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(GET, "/product/**", "/store/all", "/store/menu/**").permitAll();
        http.authorizeRequests()
                .antMatchers("/login/**", "/token/refresh/**", "/itender-openapi/**", "/swagger-ui.html",
                        "/swagger-ui/**").permitAll();
    }

    private void setSuperAdminAuthorizations(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(GET, "/user/**", "/bench/**").hasAnyAuthority(SUPER_ADMIN_ROLE);
        http.authorizeRequests().antMatchers(POST, "/role/**", "/store/**", "/bench/**").hasAnyAuthority(SUPER_ADMIN_ROLE);
        http.authorizeRequests().antMatchers(PUT, "/store/**").hasAnyAuthority(SUPER_ADMIN_ROLE);
        http.authorizeRequests().antMatchers(DELETE, "/store/**", "/bench/**").hasAnyAuthority(SUPER_ADMIN_ROLE);
    }

    private void setCommerceAdminAuthorizations(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(GET, "/user/**", "/category/**", "/product/**").hasAnyAuthority(COMMERCE_ADMIN_ROLE);
        http.authorizeRequests().antMatchers(POST, "/role/**", "/category/**", "/product/**").hasAnyAuthority(COMMERCE_ADMIN_ROLE);
        http.authorizeRequests().antMatchers(PUT, "/category/**").hasAnyAuthority(COMMERCE_ADMIN_ROLE);
        http.authorizeRequests().antMatchers(DELETE, "/category/**", "/product/**").hasAnyAuthority(COMMERCE_ADMIN_ROLE);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response)
            throws IOException, LoginException {
        log.info("Refreshing access token");
        String jwtSecret = environment.getProperty("JWT_SECRET");

        if (Objects.isNull(jwtSecret)) {
            log.error("No JWT secret was found");
            throw new SecurityException("No JWT secret was found");
        }

        String authorizationHeader = request.getHeader(AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);
                String username = decodedJWT.getSubject();
                UserApp userApp = userService.getUser(username);
                String accessToken = JWT.create()
                        .withSubject(userApp.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 3600 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", userApp.getRoles().stream().map(Role::getName).collect(
                                Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", accessToken);
                tokens.put("refresh_token", refreshToken);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new LoginException("Refresh token is missing");
        }
    }
}
