package com.revature.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Transactional
	@Override
	public String test(String test) {
		System.out.println("test from service");
		return "test " + test;
//		throw new RuntimeException("my exception");
	}

}
