package com.example.taskservice.security;

import com.example.taskservice.business.user.servcie.FindUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class AuthenticationConfiguration {
    private final FindUserService findUserService;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            com.example.taskservice.business.user.domain.User user = findUserService.find(username);
            return setGrantAuthority(username, user);
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(org.springframework.security.config.annotation.authentication.configuration.
                                                               AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    private User setGrantAuthority(String username, com.example.taskservice.business.user.domain.User user) {
        var sga = new SimpleGrantedAuthority(user.getUserRole().name());
        return new User(username, "password", Set.of(sga));
    }
}
