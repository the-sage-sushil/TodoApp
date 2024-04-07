package com.sushilmishra.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {
	
	@Autowired
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	private AuthenticationService authenticationService;
	
	@RequestMapping(value="loggin",method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";	
	}
	@RequestMapping(value="loggin",method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String username,@RequestParam String password,ModelMap model) {
	model.put("username", username);	
	 
	if(authenticationService.authenticate(username,password)) {
		return "welcome";
	  }
	
		model.put("loginstatus", "Login Failed");
		return "login";	
	}

}
