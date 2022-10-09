package com.itender;

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

import com.itender.model.Role;
import com.itender.model.User;
import com.itender.service.UserService;

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
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            if (userService.getUsers().isEmpty()) {
                userService.saveRole(new Role(null, "ROLE_USER"));
                userService.saveRole(new Role(null, "ROLE_MANAGER"));

                userService.saveUser(new User(null, "John", "john@email.com", "1234", new ArrayList<>()));

                userService.addRoleToUser("john@email.com", "ROLE_USER");
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
}
