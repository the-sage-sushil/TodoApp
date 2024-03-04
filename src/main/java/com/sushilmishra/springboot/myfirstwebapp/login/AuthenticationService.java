package com.sushilmishra.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String username,String password) {
		boolean isValidUserName=username.equalsIgnoreCase("Sushil");
		boolean isValidPassword=password.equalsIgnoreCase("mishra");
				
		return isValidUserName && isValidPassword;
	}
}
