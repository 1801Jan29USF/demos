package com.revature.dao;


import javax.transaction.Transactional.TxType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Bear;

@Repository("beardao")
public class BearDao {
	@Autowired
	private SessionFactory sf;
	
	@Transactional
	public Bear findByIdTheRightWay(int id) {
		Session se = sf.getCurrentSession();
		Bear b = (Bear) se.get(Bear.class, 1);
		return b;
	}
	

	@Transactional(propagation=Propagation.MANDATORY)
	public Bear findById(int id) {
		Session se = sf.getCurrentSession();
		Bear b = (Bear) se.get(Bear.class, 1);
		return b;
	}
	
	@Transactional(propagation=Propagation.NEVER)
	public Bear findByIdNever(int id) {
		System.out.println("entered method");
		Session se = sf.getCurrentSession();
		Bear b = (Bear) se.get(Bear.class, 1);
		
		se.save(new Bear(0, "yellow", "blakc bear", 1, 1, null, null, null));
		b.setHeight(20);
		return b;
	}
	
	@Transactional
	public Bear testMandatory(int id) {
		return findById(id);
	}
	
//	@Transactional(propagation=Propagation.REQUIRED) 
	public Bear testNever(int id) {
		System.out.println("here");
		sf.getCurrentSession().beginTransaction();
		return findByIdNever(1);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void save(Bear b, boolean error) {
		sf.getCurrentSession().save(b);
		if(error) {
			throw new RuntimeException();
		}
	}
	
	
}
