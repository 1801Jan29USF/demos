package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.BearDao;
import com.revature.entities.Bear;

@Service("bearservice")
public class BearService {
	@Autowired
	private BearDao bd;

	@Transactional
	public void testTransactions() {
		try {
			bd.save(new Bear(0, "salmon", "fish", 1, 1, null, null, null), false);
		} catch (Exception e) {
			
		}
		try {
			bd.save(new Bear(0, "brown", "polar", 1, 1, null, null, null), true);
		} catch (Exception e) {
			
		}
		
		
	}

}
