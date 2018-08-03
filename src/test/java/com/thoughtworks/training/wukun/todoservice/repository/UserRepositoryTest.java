package com.thoughtworks.training.wukun.todoservice.repository;

import com.thoughtworks.training.wukun.todoservice.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnUserWithName() {
        userRepository.save(new User(null, "wukun", "dummy"));

        Optional<User> user = userRepository.findByName("wukun");
        assertTrue(user.isPresent());
        assertThat(user.get().getName(), is("wukun"));
    }

}