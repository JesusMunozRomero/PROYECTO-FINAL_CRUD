package com.api.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Deshabilitar CSRF si no es necesario
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .anyRequest().permitAll() // Permitir todas las solicitudes sin autenticación
            )
            .formLogin().disable() // Deshabilitar la página de login
            .httpBasic().disable(); // Deshabilitar la autenticación básica

        return http.build();
    }
}
