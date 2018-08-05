package com.thoughtworks.training.wukun.user.service;

import com.thoughtworks.training.wukun.user.dto.LoginRequest;
import com.thoughtworks.training.wukun.user.exception.NotFoundException;
import com.thoughtworks.training.wukun.user.model.User;
import com.thoughtworks.training.wukun.user.repository.UserRepository;
import com.thoughtworks.training.wukun.user.security.JwtSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private JwtSignature jwtSignature;

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String login(LoginRequest loginRequest) {
        User user = getByUserName(loginRequest.getUsername());
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException(String.format("wrong password"));
        }
        return jwtSignature.generateToken(
                new LinkedHashMap<String, Object>() {{
                    put("userId", user.getId());
                }}
        );
    }

    public User getByUserName(String userName) {
        return userRepository.findByName(userName)
                .orElseThrow(NotFoundException::new);
    }

    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUser(Integer userId) {
        return Optional.ofNullable(userRepository.findOne(userId))
                .orElseThrow(NotFoundException::new);
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByName(userName);
    }

    public User getUserByToken(String token) {
        Integer userId = jwtSignature.getUserId(token);
        return getUser(userId);
    }
}
