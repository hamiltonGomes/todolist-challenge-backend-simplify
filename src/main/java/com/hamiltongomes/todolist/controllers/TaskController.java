package com.hamiltongomes.todolist.controllers;

import com.hamiltongomes.todolist.dtos.TaskCreateDto;
import com.hamiltongomes.todolist.dtos.TaskUpdateDto;
import com.hamiltongomes.todolist.entities.Task;
import com.hamiltongomes.todolist.services.impl.TaskServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping(value = "task")
@RestController
@Tag(name = "Task Controller", description = "Endpoints to control tasks")
public class TaskController {

    public final TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Create Task")
    public ResponseEntity<Task> createTask(@RequestBody @Valid TaskCreateDto taskCreateDto, UriComponentsBuilder uriBuilder) {
        Task createdTask = taskService.createTask(taskCreateDto);
        var location = uriBuilder.path("task/{id}").buildAndExpand(createdTask.getId()).toUri();
        return ResponseEntity.created(location).body(createdTask);
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Update Task")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody @Valid TaskUpdateDto taskUpdateDto) {
        Task updatedTask = taskService.updateTask(taskUpdateDto, id);
        return ResponseEntity.ok(updatedTask);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get task by ID")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping
    @Operation(summary = "Get all tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/realized")
    @Operation(summary = "Get tasks based on realized status")
    public ResponseEntity<List<Task>> getTasksByRealizedStatus(@RequestParam boolean realizedStatus) {
        return ResponseEntity.ok(taskService.getTasksByRealizedStatus(realizedStatus));
    }

    @GetMapping("/active")
    @Operation(summary = "Get tasks based on active status")
    public ResponseEntity<List<Task>> getTasksByActiveStatus(@RequestParam boolean activeStatus) {
        return ResponseEntity.ok(taskService.getTasksByActiveStatus(activeStatus));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Disable task")
    public ResponseEntity<Task> disableTask(@PathVariable Long id) {
        taskService.disableTask(id);
        return ResponseEntity.noContent().build();
    }

}
