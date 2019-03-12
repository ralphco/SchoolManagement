package com.schoolmanagement.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Component
public class LoginController {
	
	@GetMapping("/loginPage")
	public String showLoginPage() {
		
		return "login-page";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDeniedPage() {
		
		return "access-denied";
	}
	
}
