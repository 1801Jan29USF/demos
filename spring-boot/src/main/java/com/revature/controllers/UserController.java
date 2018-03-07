package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.AppUser;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService us;

	@GetMapping("role/{role}")
	public List<AppUser> findAllUsers(@PathVariable String role) {
		return us.findByRole(role);
	}

	@PostMapping
	public AppUser creatUser(@RequestBody AppUser u) {
		return us.save(u);
	}
}
