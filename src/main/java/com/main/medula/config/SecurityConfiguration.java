package com.main.medula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // desativa CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // libera endpoint público
                        .anyRequest().authenticated() // exige login nos demais
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll) // habilita login via formulário
                .httpBasic(basic -> {}); // habilita autenticação básica

        return http.build();
    }

}