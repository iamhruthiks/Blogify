package com.example.SpringBlog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.SpringBlog.util.constants.Privillages;
import com.example.SpringBlog.util.constants.Roles;

import static org.springframework.security.config.Customizer.withDefaults;

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
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(WHITELIST).permitAll() // Allow public access to these endpoints
                    .requestMatchers("/profile/**").authenticated() // Require authentication for "/profile/**"
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .requestMatchers("/editor/**").hasAnyRole("ADMIN","EDITOR")
                    .requestMatchers("/test/**").hasAuthority(Privillages.ACCESS_ADMIN_PANEL.getPrivillage())
                    //.anyRequest().authenticated() // All other requests also require authentication
            )
            .formLogin(form -> form
                    .loginPage("/login") // Specify your custom login page
                    .loginProcessingUrl("/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/",true)
                    .failureUrl("/login?error")
                    .permitAll() // Allow unauthenticated access to the login page
                    
            )
            .logout(form -> form
                .logoutUrl("/logout") // Specify your custom logout page
                .logoutSuccessUrl("/")
                
            )
            .httpBasic(withDefaults());
        
        // TODO: remove these after upgrading the DB from H2 infile DB
       http
           .csrf(csrf -> csrf.disable())  //  Disable CSRF using the new Lambda DSL
           .headers(headers -> headers.frameOptions(frame -> frame.disable())); //  Disable frame options (for H2 console)

        return http.build();
    }
}
