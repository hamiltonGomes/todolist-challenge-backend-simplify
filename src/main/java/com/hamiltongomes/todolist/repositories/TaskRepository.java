package com.hamiltongomes.todolist.repositories;

import com.hamiltongomes.todolist.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByIdAndActive(Long id, boolean active);

    List<Task> findByActiveTrue();

    List<Task> findByRealized(boolean realized);

    List<Task> findByActive(boolean activeStatus);
}
