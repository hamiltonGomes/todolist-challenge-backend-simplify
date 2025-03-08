package com.hamiltongomes.todolist.entities;

import com.hamiltongomes.todolist.dtos.TaskCreateDto;
import com.hamiltongomes.todolist.dtos.TaskUpdateDto;
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
    private Long taskId;
    private String name;
    private String description;
    private boolean isRealized = false;
    @Enumerated(EnumType.STRING)
    private TaskPriority taskPriority;

    public Task(TaskCreateDto taskCreateDto) {
        this.name = taskCreateDto.name();
        this.description = taskCreateDto.description();
        this.isRealized = taskCreateDto.isRealized();
        this.taskPriority = taskCreateDto.taskPriority();
    }

    public Task(TaskUpdateDto taskUpdateDto) {
        this.name = taskUpdateDto.name();
        this.description = taskUpdateDto.description();
        this.isRealized = taskUpdateDto.isRealized();
        this.taskPriority = taskUpdateDto.taskPriority();
    }
}
