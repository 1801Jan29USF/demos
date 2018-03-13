package com.revature.intercomm;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.entities.Account;

@Component
public class AccountClientFallback implements AccountClient {

	@Override
	public List<Account> getAccountsbyCustomer(int id) {
		return null;
	}

}
