package com.example.todos.service;


import com.example.todos.entity.TodoEntity;
import com.example.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository){

        this.todoRepository = todoRepository;
    }



    public TodoEntity create(TodoEntity todoEntity) throws Exception {

        TodoEntity newTodo = new TodoEntity(
                todoEntity.getTitle(),
                todoEntity.getBody()
        );

        if(newTodo.getTitle().isEmpty()){
            throw new Exception("title is empty");
        }
        if(newTodo.getBody().isEmpty()){
            throw new Exception("body is empty");
        }

        return todoRepository.save(newTodo);

    }


    public Optional<TodoEntity> updateTodo(Long id, TodoEntity todoEntity){
        Optional<TodoEntity> optionalTodoEntity = todoRepository.findByTodoId(id);

        TodoEntity todo = new TodoEntity();

        if (optionalTodoEntity.isPresent()) {

            todo = optionalTodoEntity.get();

            if (todoEntity.getTitle() != null && !todoEntity.getTitle().equals(todo.getTitle())) {
                todo.setTitle(todoEntity.getTitle());
            }

            if (todoEntity.getBody() != null && !todoEntity.getBody().equals(todo.getBody())){
                todo.setBody(todoEntity.getBody());

            }

            todoRepository.save(todo);

        }

        return  Optional.of(todo);

    }

    public void deleteTodo(Long id){
        Optional<TodoEntity> todoEntity = todoRepository.findById(id);

        if (todoEntity.isPresent()){
            todoRepository.deleteById(id);
        }
    }



}
