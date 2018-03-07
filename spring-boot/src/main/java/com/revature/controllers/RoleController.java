package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Role;
import com.revature.services.RoleService;

@RestController
@RequestMapping("roles")
public class RoleController {
	@Autowired
	private RoleService rs;

	@PostMapping
	public Role createRole(@RequestBody Role role) {
		return rs.save(role);
	}

	@GetMapping
	public List<Role> findAll() {
		return rs.findall();
	}
	
	@GetMapping("name/{name}")
	public Role findById(@PathVariable String name) {
		return rs.findByName(name);
	}

}
