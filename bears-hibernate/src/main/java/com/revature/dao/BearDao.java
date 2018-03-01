package com.revature.dao;

import java.util.List;
import java.util.Set;

import com.revature.entities.Bear;

public interface BearDao {
	// C
	Bear save(Bear b);
	Bear persist(Bear b);
	
	// R
	Bear getById(int id);
	Bear loadById(int id);
	List<Bear> getAll();
	Set<Bear> findByBreedCriteria(String breed);
	Set<Bear> findByBreedHQL(String breed);
	
	// U
	Bear update(Bear b);
	Bear merge(Bear b);// D
	void delete(Bear b);
	

}
