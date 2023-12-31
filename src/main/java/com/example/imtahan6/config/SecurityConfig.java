package com.example.imtahan6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        return security.authorizeHttpRequests(rgs ->
                        rgs.requestMatchers(HttpMethod.POST, "/company/**").permitAll()
                                .requestMatchers(HttpMethod.GET ,"/company/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/user/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/user/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/registration/**").permitAll()
                )
                .csrf(csrf -> csrf.disable())
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
