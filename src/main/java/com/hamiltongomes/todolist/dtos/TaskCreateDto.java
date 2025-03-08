package com.hamiltongomes.todolist.dtos;

import com.hamiltongomes.todolist.enums.TaskPriority;
import jakarta.validation.constraints.NotBlank;

public record TaskCreateDto(
        @NotBlank
        String name,
        String description,
        boolean isRealized,
        TaskPriority taskPriority
) {
}
