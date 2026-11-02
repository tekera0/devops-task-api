package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private List<Todo> todos = new ArrayList<>();
    private int currentId = 1;

    public TodoController() {
        // Add a default task so the list isn't empty
        todos.add(new Todo(currentId++, "Complete DevOps Assignment", false));
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todos;
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo newTodo) {
        newTodo.setId(currentId++);
        todos.add(newTodo);
        return newTodo;
    }
}