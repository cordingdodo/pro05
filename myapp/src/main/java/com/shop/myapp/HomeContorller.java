package com.shop.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeContorller {
	
	@GetMapping("/")
	@ResponseBody
	public String goMain(HttpServletRequest request) {
		return "Spring Boot Main Home";
	}
	
	@GetMapping("/home")
	@ResponseBody
	public String goHome(HttpServletRequest request) {
		return "Spring Boot Home OK~!";
	}
	
}
