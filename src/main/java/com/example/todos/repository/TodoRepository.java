package com.example.todos.repository;

import com.example.todos.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {


    @Query("SELECT t FROM TodoEntity t WHERE t.id=?1")
    Optional<TodoEntity> findByTodoId (Long id);

    @Query("SELECT a FROM TodoEntity a ORDER BY a.id desc ")
    List<TodoEntity> findAllTodos();


}
