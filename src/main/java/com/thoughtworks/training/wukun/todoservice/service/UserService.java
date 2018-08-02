package com.thoughtworks.training.wukun.todoservice.service;

import com.thoughtworks.training.wukun.todoservice.dto.LoginRequest;
import com.thoughtworks.training.wukun.todoservice.security.JwtSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class UserService {
    @Autowired
    private JwtSignature jwtSignature;

    @Autowired
    private UserDetailsService userDetailsService;

    public String login(LoginRequest loginRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        if (userDetails == null) {
            throw new UsernameNotFoundException(String.format("user not found"));
        }
        if (!loginRequest.getPassword().equals(userDetails.getPassword())) {
            throw new BadCredentialsException(String.format("wrong password"));
        }
        return jwtSignature.generateToken(
                new LinkedHashMap<String, Object>() {{
                    put("user", loginRequest.getUsername());
                }}
        );

    }
}
