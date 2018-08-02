package com.thoughtworks.training.wukun.todoservice.security;

import com.google.common.collect.ImmutableList;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class ToDoUserDetailsService extends InMemoryUserDetailsManager {
    public ToDoUserDetailsService() {
        super(new User("user", "password", ImmutableList.of(new SimpleGrantedAuthority("admin"))));
    }
}
