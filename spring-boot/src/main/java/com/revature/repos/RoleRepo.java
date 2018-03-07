package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
	Role findByRole(String role);
}
