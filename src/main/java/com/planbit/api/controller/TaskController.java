package com.planbit.api.controller;

import com.planbit.api.exception.ResourceNotFoundException;
import com.planbit.api.model.Task;
import com.planbit.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) throws ResourceNotFoundException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id: " + id));
        return ResponseEntity.ok().body(task);
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) throws ResourceNotFoundException {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id: " + id));

        existingTask.setName(task.getName());
        existingTask.setStartTime(task.getStartTime());
        existingTask.setEndTime(task.getEndTime());

        return ResponseEntity.ok(taskRepository.save(existingTask));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Task not found for this id: " + id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}