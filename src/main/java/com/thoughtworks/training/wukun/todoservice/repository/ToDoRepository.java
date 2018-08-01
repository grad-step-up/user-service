package com.thoughtworks.training.wukun.todoservice.repository;

import com.thoughtworks.training.wukun.todoservice.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
}
