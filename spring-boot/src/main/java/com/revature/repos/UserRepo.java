package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Integer> {
	
	List<AppUser> findByRoleRole(String role);

}
