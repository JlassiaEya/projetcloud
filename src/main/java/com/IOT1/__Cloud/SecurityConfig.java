package com.IOT1.__Cloud;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Désactiver CSRF pour REST API
            .authorizeHttpRequests()
                .requestMatchers("/api/**").permitAll() // Autoriser toutes les requêtes API
                .anyRequest().authenticated()
            .and()
            .cors(); // Activer CORS

        return http.build();
    }
}
