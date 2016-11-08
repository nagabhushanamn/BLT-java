package com.bank.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;

@Service("txrService")
public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger("bank");

	private AccountRepository accountRepository;

	public TxrServiceImpl() {
		logger.info("TxrService instance created....");
	}

	// @Required
	@Autowired(required = true)
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("AccountRepository injected to TxrService");
	}

	public void init() {
		logger.info("TxrService : init()");
	}

	public void destroy() {
		logger.info("TxrService : destroy()");
	}

	@Transactional(transactionManager = "hibTransactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean txr(double amount, String from, String to) {

		boolean status = false;

		Account fromAccount = accountRepository.load(from);
		Account toAccount = accountRepository.load(to);
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

		System.out.println(fromAccount);
		System.out.println(toAccount);

		status = true;

		return status;
	}

}
