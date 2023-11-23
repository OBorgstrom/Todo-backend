package com.example.todos.controller;


import com.example.todos.entity.TodoEntity;
import com.example.todos.repository.TodoRepository;
import com.example.todos.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/todos")
public class TodoController {

    private final TodoService todoService;

    private final TodoRepository todoRepository;


    @CrossOrigin
    @PostMapping("/create")
    public TodoEntity createTodo(@RequestBody TodoEntity todoEntity) throws Exception {
        return todoService.create(todoEntity);
    }

    @CrossOrigin
    @PutMapping("/update")
    public Optional<TodoEntity> updateTodo(@RequestHeader(value = "id") Long id, @RequestBody TodoEntity todo) {
        return todoService.updateTodo(id, todo);
    }

    @CrossOrigin
    @DeleteMapping(path = "/delete")
    public void deleteTodo(@RequestHeader(value = "id") Long id) {
        todoService.deleteTodo(id);
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<TodoEntity> findAllTodos() {
        return todoRepository.findAllTodos().stream().collect(Collectors.toList());

    }

}
