package com.shipan.cruddemo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails john = User.builder().username("john").password("{noop}test123").roles("STUDENT").build();
        UserDetails susi = User.builder().username("susi").password("{noop}test123").roles("STUDENT","MANAGER").build();

        return new InMemoryUserDetailsManager(john,susi);
    }
}
