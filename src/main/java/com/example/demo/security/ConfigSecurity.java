package com.example.demo.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.PasswordManagementConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class ConfigSecurity {
    private  final MongoUserDetailsService mongoUserDetailsService;

    @Autowired
    public ConfigSecurity(MongoUserDetailsService mongoUserDetailsService) {
        this.mongoUserDetailsService = mongoUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(login ->{
                    login.loginPage("/login").permitAll();
                })
                .logout(log ->{
                    log.logoutUrl("/logout");
                })
                .authorizeHttpRequests(auth ->{
                    auth.requestMatchers("/api/**").authenticated();
                    auth.requestMatchers(HttpMethod.GET,"/get").permitAll();
                    auth.requestMatchers(HttpMethod.POST,"/get").permitAll();
                })
                .userDetailsService(mongoUserDetailsService)
                .csrf().disable()
                .build();
    }
}
