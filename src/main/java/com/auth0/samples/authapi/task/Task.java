package com.auth0.samples.authapi.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private long id;

	@Getter
	@Setter
	private String description;

	protected Task() { }

	public Task(String description) {
		this.description = description;
	}
}
