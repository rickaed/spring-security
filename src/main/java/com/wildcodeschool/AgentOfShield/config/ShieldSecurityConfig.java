package com.wildcodeschool.AgentOfShield.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ShieldSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/").permitAll()
                        .antMatchers("/secret-bases").hasRole("DIRECTOR")
                        .antMatchers("/avengers/assemble").hasRole("CHAMPION")
                        .anyRequest().authenticated())
                .formLogin();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails champion = User
                .withUsername("champion")
                .password(encoder.encode("Champion"))
                .roles("CHAMPION")
                .build();

        UserDetails director = User
                .withUsername("Coulson")
                .password(encoder.encode("Fiory"))
                .roles("DIRECTOR")
                .build();

        // UserDetails all = User
        // .withUsername("")
        // .password(encoder.encode(""))
        // .roles("ALL")
        // .build();

        return new InMemoryUserDetailsManager(List.of(director, champion));
    }
}