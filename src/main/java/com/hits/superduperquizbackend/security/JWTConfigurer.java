package com.hits.superduperquizbackend.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JWTokenFilter jwTokenFilter;

    public JWTConfigurer(JWTokenFilter jwTokenFilter) {
        this.jwTokenFilter = jwTokenFilter;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) {
        httpSecurity.addFilterBefore(jwTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
