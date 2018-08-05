package com.thoughtworks.training.wukun.user.service;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.wukun.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class FixtureCreator implements ApplicationRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ImmutableList.of("wukun", "xiejia", "yuwei")
                .forEach(userName -> userService.create(
                        new User(null, userName, "hello")
                ));
    }
}
