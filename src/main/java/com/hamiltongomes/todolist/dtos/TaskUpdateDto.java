package com.hamiltongomes.todolist.dtos;

import com.hamiltongomes.todolist.enums.TaskPriority;

public record TaskUpdateDto(
        String name,
        String description,
        boolean isRealized,
        TaskPriority taskPriority
) {
}
