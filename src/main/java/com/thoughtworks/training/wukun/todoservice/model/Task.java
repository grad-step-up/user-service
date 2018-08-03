package com.thoughtworks.training.wukun.todoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Builder
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    public Task(String content) {
        this.content = content;
    }
    public Task() {
    }

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "todo_id")
//    @JsonIgnore
//    private ToDo toDo;
}
