package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Account;
import com.revature.entities.Customer;
import com.revature.intercomm.AccountClient;

@RestController
public class CustomerController {
	@Autowired
	private AccountClient ac;

	private List<Customer> customers;

	public CustomerController() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "Chris W.", null));
		customers.add(new Customer(2, "John Brown", null));
		customers.add(new Customer(3, "Austin", null));
		customers.add(new Customer(4, "Stephen", null));
		customers.add(new Customer(5, "Kelton", null));
	}

	@GetMapping("{id}")
	public ResponseEntity<Customer> findById(@PathVariable int id) {
		ResponseEntity<Customer> resp;
		Customer c = customers.stream().filter(cust -> cust.getId() == id).findFirst().get();
		List<Account> accounts = ac.getAccountsbyCustomer(id);
		c.setAccounts(accounts);
		if (accounts == null) {
			resp = new ResponseEntity<>(c, HttpStatus.PARTIAL_CONTENT);
		} else {
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		}
		return resp;
	}
}
