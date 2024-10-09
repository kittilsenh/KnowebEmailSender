package com.example.emailsender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Disable CSRF protection for testing
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().permitAll()  // Allow all requests without authentication
                )
                .formLogin().disable()  // Disable Spring Security's form login handling
                .logout().disable();  // Disable Spring Security's logout handling

        return http.build();
    }
}
