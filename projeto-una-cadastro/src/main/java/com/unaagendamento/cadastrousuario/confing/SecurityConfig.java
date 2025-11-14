package com.unaagendamento.cadastrousuario.confing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // <-- A LINHA MAIS IMPORTANTE: DESABILITA O CSRF
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, "/usuario").permitAll()
                .anyRequest().authenticated() // Exige autenticação para qualquer requisição
            )
            .httpBasic(withDefaults()); // Usa autenticação HTTP Basic

        return http.build();
    }
}
