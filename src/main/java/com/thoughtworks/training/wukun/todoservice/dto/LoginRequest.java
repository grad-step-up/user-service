package com.thoughtworks.training.wukun.todoservice.dto;

import lombok.Data;

@Data
public class LoginRequest {
    String username;

    String password;
}
