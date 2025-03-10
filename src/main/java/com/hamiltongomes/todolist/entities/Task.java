package com.hamiltongomes.todolist.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hamiltongomes.todolist.dtos.TaskCreateDto;
import com.hamiltongomes.todolist.enums.TaskPriority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "TASK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean realized = false;
    @Enumerated(EnumType.STRING)
    private TaskPriority taskPriority;
    @JsonIgnore
    private boolean active = true;

    public Task(TaskCreateDto taskCreateDto) {
        this.name = taskCreateDto.name();
        this.description = taskCreateDto.description();
        this.realized = taskCreateDto.realized();
        this.taskPriority = taskCreateDto.taskPriority();
    }
}
