package com.hamiltongomes.todolist.services;

import com.hamiltongomes.todolist.dtos.TaskCreateDto;
import com.hamiltongomes.todolist.dtos.TaskUpdateDto;
import com.hamiltongomes.todolist.entities.Task;

import java.util.List;

public interface TaskService {
    Task createTask(TaskCreateDto taskCreateDto);

    Task updateTask(TaskUpdateDto taskUpdateDto, Long taskId);

    Task getTaskById(Long taskId);

    List<Task> getAllTasks();

    List<Task> getTasksByRealizedStatus(boolean realizedStatus);

    List<Task> getTasksByActiveStatus(boolean activeStatus);

    void disableTask(Long taskId);
}
