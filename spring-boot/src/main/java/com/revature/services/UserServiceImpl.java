package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.AppUser;
import com.revature.repos.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo ur;

	
	@Override
	public AppUser save(AppUser u) {
		return ur.save(u);
	}



	@Override
	public List<AppUser> findByRole(String role) {
		return ur.findByRoleRole(role);
	}

}
