package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.entities.Test;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public Test getSharpestTest() {
		return new Test(5, false, 1.2);
	}

}
