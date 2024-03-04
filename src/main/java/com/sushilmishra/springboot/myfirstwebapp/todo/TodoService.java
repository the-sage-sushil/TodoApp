package com.sushilmishra.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos =new ArrayList();
	
	private static int todoCount = 0;
	static {
		todos.add(new Todo(++todoCount,"in28minutes","Learn AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"in28minutes","Learn Devops",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todoCount,"in28minutes","Learn Full Stack ",LocalDate.now().plusYears(3),false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	
	public List<Todo> addNewTodos(String username,String description,LocalDate date,boolean done){
		
		todos.add(new Todo(++todoCount,username,description,date,done));
		
		return todos;
		
	}
}
