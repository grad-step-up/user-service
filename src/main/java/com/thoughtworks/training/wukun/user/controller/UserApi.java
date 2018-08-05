package com.thoughtworks.training.wukun.user.controller;

import com.thoughtworks.training.wukun.user.dto.LoginRequest;
import com.thoughtworks.training.wukun.user.model.User;
import com.thoughtworks.training.wukun.user.security.Constants;
import com.thoughtworks.training.wukun.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserApi {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String token = userService.login(loginRequest);
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, Constants.BEARER_TOKEN_PREFIX + token)
                .body(token);
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/verifications")
    public ResponseEntity verifyToken(@RequestBody String token) {
        try {
            return ResponseEntity.ok(userService.getUserByToken(token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/users")
    public List<User> list() {
        return userService.list();
    }
}
