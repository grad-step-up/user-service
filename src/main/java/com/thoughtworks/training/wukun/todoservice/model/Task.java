package com.thoughtworks.training.wukun.todoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Integer id;

    private String content;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "todo_id")
//    @JsonIgnore
//    private ToDo toDo;
}
