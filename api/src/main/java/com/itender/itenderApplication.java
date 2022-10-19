package com.itender;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.itender.model.Role;
import com.itender.model.UserApp;
import com.itender.service.UserService;
import com.itender.utils.Sex;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
@Configuration
@EntityScan(basePackageClasses = { itenderApplication.class, Jsr310JpaConverters.class })
public class itenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(itenderApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            if (userService.getUsers().isEmpty()) {
                userService.saveRole(new Role(null, "ROLE_ADMIN", LocalDateTime.now(), LocalDateTime.now()));
                userService.saveRole(new Role(null, "ROLE_WAITER", LocalDateTime.now(), LocalDateTime.now()));

                userService.saveUser(
                        new UserApp(null, "John", "Mejia", "3134554632", Sex.MALE, "john@email.com",
                                "1234", new ArrayList<>(), null, LocalDateTime.now(), LocalDateTime.now()));

                userService.addRoleToUser("john@email.com", "ROLE_ADMIN");
            }
        };
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components())
                .info(new Info().title("itender application")
                        .description("itender application")
                        .version("1.0"));
    }

    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }

}
