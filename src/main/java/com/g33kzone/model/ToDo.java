package com.g33kzone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ToDo {

	private Long id;
	private String taskName;
	private Integer taskPriority;
	private String taskStatus;

	public ToDo() {
		super();
	}

	public ToDo(String taskName, Integer taskPriority, String taskStatus) {
		super();
		this.taskName = taskName;
		this.taskPriority = taskPriority;
		this.taskStatus = taskStatus;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(Integer taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

}
