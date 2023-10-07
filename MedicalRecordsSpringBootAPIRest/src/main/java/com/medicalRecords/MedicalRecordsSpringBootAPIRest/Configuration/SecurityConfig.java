package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    /**
     * The function configures the HttpSe
     * curity to require the "Admin" authority for requests to
     * "/users/**" and "/settings/**" endpoints.
     * 
     * @param http The "http" parameter 
     * is an instance of the HttpSecurity class, which is used to
     * configure the security settings for the application's HTTP requests.
     */
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/users/**", "/settings/**").hasAuthority("Admin");
    }
}

