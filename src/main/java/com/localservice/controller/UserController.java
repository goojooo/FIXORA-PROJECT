package com.localservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.localservice.model.User;
import com.localservice.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// ❌ REMOVE @GetMapping("/register") — React handles this now
	// ❌ REMOVE @GetMapping("/dashboard") — React handles this now

	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user) {
		userService.registerUser(user);
		return "redirect:/login";
	}

}