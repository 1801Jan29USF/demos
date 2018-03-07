package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService us;

	@GetMapping
	public void test() {
		us.test("my test");
	}
}
