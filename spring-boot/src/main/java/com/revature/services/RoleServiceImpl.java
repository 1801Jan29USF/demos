package com.revature.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Role;
import com.revature.repos.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepo roleRepo;

	@Override
	@Transactional
	public Role save(Role role) {
		return roleRepo.save(role);
	}

}
