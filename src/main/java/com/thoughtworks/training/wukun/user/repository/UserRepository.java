package com.thoughtworks.training.wukun.user.repository;

import com.thoughtworks.training.wukun.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String userName);
}
