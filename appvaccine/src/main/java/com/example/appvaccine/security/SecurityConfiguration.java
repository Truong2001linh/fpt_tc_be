package com.example.appvaccine.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilrerChain(HttpSecurity http) throws Exception {
        System.out.println("2");
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/**")
                .permitAll()
                .requestMatchers("/vaccine/addVaccine").permitAll()
                .requestMatchers("/vaccine/upload").permitAll()
                .requestMatchers("/vaccine/getAllVacine1").permitAll()
                .requestMatchers("/vaccine/findByIdImage/{id}").permitAll()
                .requestMatchers("/vaccine-images/**").permitAll()
                .requestMatchers("/image/**").permitAll()
                .requestMatchers("/profile/**").permitAll()
                .requestMatchers("/vaccineFacility/**").permitAll()
                .requestMatchers("/relationship/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();

    }
}
