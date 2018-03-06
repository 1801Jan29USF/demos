package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Test;
import com.revature.services.TestService;

@RestController // @RestController implies @ResponseBody for all methods
@RequestMapping("test")
public class TestController {

	@Autowired
	private TestService testService;

	@GetMapping
	public String test() {
		System.out.println("this is a test");
		return "hello";
	}

	@GetMapping("{id}")
	public void findById(@PathVariable int id) {
		System.out.println("finding test with id: " + id);
	}

	@PostMapping
	public Test createTest(@RequestBody Test t) {
		System.out.println("creating test: " + t);
		t.setId(1);
		return t;
	}

	/**
	 * Response entity can be used to attach an object to the body as well as set
	 * the status code
	 * 
	 * @return
	 */
	@GetMapping("status")
	public ResponseEntity<Test> statusTest() {
		ResponseEntity<Test> resp = new ResponseEntity<Test>(new Test(), HttpStatus.BAD_GATEWAY);
		return resp;
	}
	
	@GetMapping("sharpest")
	public Test getSharpest() {
		return testService.getSharpestTest();
	}

}
