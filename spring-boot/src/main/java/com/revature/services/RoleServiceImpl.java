package com.revature.services;

import java.util.List;

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

	@Override
	public List<Role> findall() {
		return roleRepo.findAll();
	}

	@Override
	public Role findByName(String name) throws Exception {
		Role r = roleRepo.findByRole(name);
		if(r == null) {
			throw new Exception("message");
		}
		return r;
	}

}
