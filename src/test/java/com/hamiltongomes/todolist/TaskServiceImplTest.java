package com.hamiltongomes.todolist;

import com.hamiltongomes.todolist.dtos.TaskCreateDto;
import com.hamiltongomes.todolist.entities.Task;
import com.hamiltongomes.todolist.enums.TaskPriority;
import com.hamiltongomes.todolist.repositories.TaskRepository;
import com.hamiltongomes.todolist.services.impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTaskSuccess() {
        var dto = new TaskCreateDto("Tarefa 1", "Descrição da tarefa", false, TaskPriority.MEDIUM);
        var task = new Task(dto);

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = taskService.createTask(dto);

        assertNotNull(createdTask);
        assertEquals("Tarefa 1", createdTask.getName());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void testCreateTaskFailureNullName() {
        TaskCreateDto invalidDto = new TaskCreateDto(null, "Descrição da tarefa", false, TaskPriority.MEDIUM);

        when(taskRepository.save(any(Task.class)))
                .thenThrow(new RuntimeException("Nome não pode ser nulo"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> taskService.createTask(invalidDto),
                "Deve lançar exceção ao tentar criar uma Task com nome nulo");

        assertEquals("Nome não pode ser nulo", exception.getMessage());
    }
}
