package com.bank.repository;

import com.bank.model.Account;

public interface AccountRepository {
	
	public Account load(String num);
	public void update(Account account);

}
