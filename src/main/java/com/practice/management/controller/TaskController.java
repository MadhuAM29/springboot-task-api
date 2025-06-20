package com.practice.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.management.entity.Task;
import com.practice.management.error.TaskNotFoundException;
import com.practice.management.respository.TaskRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskRepository repo;

	@GetMapping
	public List<Task> getTask() {
		return repo.findAll();
	}

	@PostMapping
	public Task createTask(@Valid @RequestBody Task task) {
		return repo.save(task);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedtask) {
		Task task = repo.findById(id).orElseThrow(() -> new TaskNotFoundException(id));

		task.setTitle(updatedtask.getTitle());
		task.setDescription(updatedtask.getDescription());
		task.setCompleted(updatedtask.isCompleted());

		return ResponseEntity.ok(repo.save(task));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		Task existingTask = repo.findById(id).orElseThrow(() -> new TaskNotFoundException(id));

		repo.delete(existingTask);

		return ResponseEntity.noContent().build();

	}
}
