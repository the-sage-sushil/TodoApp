package com.sushilmishra.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class TodoController {
	
	private TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("in28minutes");
		model.addAttribute("todos",todos);
		return "listTodos";
	}

	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String getAddTodosPage(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("in28minutes");
		return "todo";
	}

	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String addTodosPage(@RequestParam String description,
	@RequestParam String username,@RequestParam LocalDate date,
	@RequestParam boolean done,ModelMap model) 
	{
		model.addAttribute("todos",todoService.addNewTodos(username,description,date,done));
		return "redirect:list-todos";
	}
	
}
