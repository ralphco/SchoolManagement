package com.schoolmanagement.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Component
public class MainController {
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
}
