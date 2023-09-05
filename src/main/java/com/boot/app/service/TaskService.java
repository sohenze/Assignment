package com.boot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.app.entity.Task;
import com.boot.app.repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task newTask = taskRepository.save(task);
        return ResponseEntity.ok(newTask);
    }

    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskRepository.findAll());
    }

    public ResponseEntity<Optional<Task>> getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (!task.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    public ResponseEntity<String> deleteTaskById(Long id) {
        taskRepository.deleteById(id);
        return ResponseEntity.ok("Task Deleted Successfully");
    }

    public ResponseEntity<Task> updateTaskById(Long id, Task updatedTask) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.getCompleted());

        Task savedTask = taskRepository.save(existingTask);
        return ResponseEntity.ok(savedTask);
    }
}
