package com.example.SpringStarter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {

    private static final String[] WHITELIST = {
            "/",
            "/login",
            "/register",
            "/db-console/**",
            "/css/**",
            "/fonts/**",
            "images/**",
            "/js/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(WHITELIST).permitAll() // Allow public access to these endpoints
                    .anyRequest().authenticated() // All other requests require authentication
            )
            .formLogin(form -> form
                    .loginPage("/login") // Specify your custom login page
                    .permitAll() // Allow unauthenticated access to the login page
            );
        
        // TODO: remove these after upgrading the DB from H2 infile DB
       http
           .csrf(csrf -> csrf.disable())  //  Disable CSRF using the new Lambda DSL
           .headers(headers -> headers.frameOptions(frame -> frame.disable())); //  Disable frame options (for H2 console)

        return http.build();
    }
}
