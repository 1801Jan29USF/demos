package com.revature.services;

import java.util.List;

import com.revature.entities.Role;

public interface RoleService {
	Role save(Role role);

	List<Role> findall();

	Role findByName(String name);
}
