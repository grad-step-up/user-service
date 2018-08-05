package com.thoughtworks.training.wukun.user.dto;

import lombok.Data;

@Data
public class LoginRequest {
    String username;

    String password;
}
