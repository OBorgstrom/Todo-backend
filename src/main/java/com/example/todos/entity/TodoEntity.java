package com.example.todos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    @Id
    @SequenceGenerator(
            name = "cleaners_sequence",
            sequenceName = "cleaners_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cleaners_sequence"
    )

    private Long id;


    public TodoEntity(String title, String body){
        this.title = title;
        this.body = body;
    }

    private String title;

    private String body;



}
