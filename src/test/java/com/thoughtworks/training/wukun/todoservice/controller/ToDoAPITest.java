package com.thoughtworks.training.wukun.todoservice.controller;

import com.thoughtworks.training.wukun.todoservice.repository.ToDoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ToDoAPITest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoRepository toDoRepository;


    @Test
    public void shouldReturnItemsList() throws Exception {
//        when(toDoRepository.list())
//                .thenReturn(ImmutableList.of(new ToDo(0, "foo")));

//        mockMvc.perform(get("/todos"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(1))
//                .andExpect(jsonPath("$[0].id").value(0))
//                .andExpect(jsonPath("$[0].text").value("foo"));
    }
}