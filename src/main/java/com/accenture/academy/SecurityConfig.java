package com.accenture.academy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                request -> request
                        .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET,"/api")).hasRole("USER")
                        .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.POST,"/api")).hasRole("ADMIN")
                        .anyRequest()
                        .permitAll()
        ).build();
    }
}
