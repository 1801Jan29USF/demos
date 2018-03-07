package com.revature.services;

import java.util.List;

import com.revature.entities.AppUser;

public interface UserService {

	AppUser save(AppUser u);


	List<AppUser> findByRole(String role);
}
