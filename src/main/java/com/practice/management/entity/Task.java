package com.practice.management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//marks this class as JPA entity
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	
	@Id//Primary key field.
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Auto-generates id using database identity strategy.
	private Long id;
	
	@NotBlank(message= "Title is mandatory")
	private String title;
	public String getTitle() {
	    return title;
	}
	public void setTitle(String title) {
	    this.title = title;
	}
	
	 public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	private String description;
	
	private boolean completed = false;
	
	/*
	 * public Task() {
	 * 
	 * }
	 * 
	 * public Task(String title,String description,boolean completed) {
	 * this.title=title; this.description=description; this.completed=completed; }
	 * 
	 * @Override public String toString() { return "Task{" + "id=" + id +
	 * ", title='" + title + '\'' + ", description='" + description + '\'' +
	 * ", completed=" + completed + '}'; }
	 */
}
