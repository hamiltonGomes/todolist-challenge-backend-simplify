package com.hamiltongomes.todolist.services.impl;

import com.hamiltongomes.todolist.dtos.TaskCreateDto;
import com.hamiltongomes.todolist.dtos.TaskUpdateDto;
import com.hamiltongomes.todolist.entities.Task;
import com.hamiltongomes.todolist.exceptions.TaskNotFoundException;
import com.hamiltongomes.todolist.repositories.TaskRepository;
import com.hamiltongomes.todolist.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(TaskCreateDto taskCreateDto) {
        Task newTask = new Task(taskCreateDto);
        return taskRepository.save(newTask);
    }

    @Override
    public Task updateTask(TaskUpdateDto taskUpdateDto, Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            if (!task.getDescription().equals(taskUpdateDto.description()) && taskUpdateDto.description() != null) {
                task.setDescription(taskUpdateDto.description());
            }
            if (!task.getName().equals(taskUpdateDto.name()) && taskUpdateDto.name() != null) {
                task.setName(taskUpdateDto.name());
            }
            if (task.isRealized() != taskUpdateDto.realized()) {
                task.setRealized(taskUpdateDto.realized());
            }
            if (!task.getTaskPriority().equals(taskUpdateDto.taskPriority()) && taskUpdateDto.taskPriority() != null) {
                task.setTaskPriority(taskUpdateDto.taskPriority());
            }

            return taskRepository.save(task);
        } else {
            throw new TaskNotFoundException(taskId);
        }
    }

    @Override
    public Task getTaskById(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findByIdAndActive(taskId, true);
        if (optionalTask.isPresent()) {
            return optionalTask.get();
        }
        throw new TaskNotFoundException(taskId);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findByActiveTrue();
    }

    @Override
    public List<Task> getTasksByRealizedStatus(boolean realizedStatus) {
        return taskRepository.findByRealized(realizedStatus);
    }

    @Override
    public List<Task> getTasksByActiveStatus(boolean activeStatus) {
        return taskRepository.findByActive(activeStatus);
    }

    @Override
    public void disableTask(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setActive(false);
            taskRepository.save(task);
        } else {
            throw new TaskNotFoundException(taskId);
        }
    }
}
