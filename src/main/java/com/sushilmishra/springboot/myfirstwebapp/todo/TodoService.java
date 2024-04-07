package com.sushilmishra.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList();

	private static int todoCount = 0;
	static {
		todos.add(new Todo(++todoCount, "in28minutes", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "in28minutes", "Learn Devops", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todoCount, "in28minutes", "Learn Full Stack ", LocalDate.now().plusYears(3), true));
	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}

	public List<Todo> addNewTodos(int id, String username, String description, LocalDate date, boolean done) {

		todos.add(new Todo(id, username, description, date, done));
		return todos;
	}

	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate = todos -> todos.getId() == id;
		todos.removeIf(predicate);
	}

	public void updateTodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todos -> todos.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
}
