package com.boot.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.app.entity.Task;
import com.boot.app.service.TaskService;

@RestController
@RequestMapping("/")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Optional<Task>> getTaskById(@PathVariable Long id) {
        ResponseEntity<Optional<Task>> task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return task;
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Long id) {
        return taskService.deleteTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTaskById(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTaskById(id, task);
    }
}
