package com.sushilmishra.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

public class Todo {

	public Todo(int id, String username, String discription, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.discription = discription;
		this.targetDate = targetDate;
		this.done = done;
	}

	private int id;
	private String username;

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", discription=" + discription + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	private String discription;
	private LocalDate targetDate;
	private boolean done;
}
