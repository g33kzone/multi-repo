package com.g33kzone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g33kzone.model.ToDo;
import com.g33kzone.repository.UserJpaRepository;

@Service
public class ToDoService {

	@Autowired
	private UserJpaRepository userJpaRepository;

	public List<ToDo> fetchAllTasks() {
		return userJpaRepository.findAll();
	}

	public Optional<ToDo> fetchTask(Long id) {
		return userJpaRepository.findById(id);
	}

	public ToDo addTask(ToDo todo) {
		ToDo returnedToDo = userJpaRepository.save(todo);

		return returnedToDo;
	}

	public String addManyTask(List<ToDo> todolist) {

		for (ToDo toDo : todolist) {
			userJpaRepository.save(toDo);
		}

		return "Tasks created successfully";
	}

	public String deleteTask(Long id) {
		userJpaRepository.deleteById(id);

		return "Task deleted successfully";
	}

}
