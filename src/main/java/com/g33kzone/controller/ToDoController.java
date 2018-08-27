package com.g33kzone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.g33kzone.model.ToDo;
import com.g33kzone.service.ToDoService;

@RestController
@RequestMapping("todo")
public class ToDoController {

	@Autowired
	private ToDoService toDoService;

	// GET request - displays text with status code 200
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE, path = "/hello")
	public ResponseEntity<String> helloUser() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello User !!");
	}

	// GET request - fetches all tasks with status code 200
	@GetMapping(path = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ToDo>> fetchAllTasks() {

		return ResponseEntity.status(HttpStatus.OK).body(toDoService.fetchAllTasks());
	}

	// GET request - fetches a task based on task id with status code 200
	@GetMapping(path = "/task/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<ToDo>> fetchTask(@PathVariable Long taskId) {

		return ResponseEntity.status(HttpStatus.OK).body(toDoService.fetchTask(taskId));
	}

	// POST request - create a task (input JSON) with status code 201
	@PostMapping(path = "/addtask", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ToDo> addTask(@RequestBody ToDo todoTask) {

		return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.addTask(todoTask));
	}

	// POST request - create a task (input JSON) with status code 201
	@PostMapping(path = "/addmanytask", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addManyTask(@RequestBody List<ToDo> todoTask) {

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(toDoService.addManyTask(todoTask));
	}

	// DELETE request - delete a task (input via PathVariable) with status code 204
	@DeleteMapping(path = "/deletetask/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(toDoService.deleteTask(taskId));
	}

}
