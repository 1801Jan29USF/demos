package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@ResponseStatus(code=HttpStatus.I_AM_A_TEAPOT)
	public List<Role> findAll() {
		return rs.findall();
	}

	@GetMapping("name/{name}")
	public Role findById(@PathVariable String name) throws Exception {
		Role r = rs.findByName(name);
		return r;
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<String> handleException(Exception e) {
		ResponseEntity<String> resp = new ResponseEntity<String>("exception", HttpStatus.BAD_REQUEST);
		System.out.println("here");
		return resp;
	}

}
