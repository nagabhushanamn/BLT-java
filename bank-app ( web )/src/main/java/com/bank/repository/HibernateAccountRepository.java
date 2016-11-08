package com.bank.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bank.model.Account;

//@Component
@Repository
public class HibernateAccountRepository implements AccountRepository {

	private SessionFactory sessionFactory;

	// @Autowired
	public HibernateAccountRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Account load(String num) {
		return sessionFactory.getCurrentSession().get(Account.class, num);
	}

	public void update(Account account) {
		sessionFactory.getCurrentSession().merge(account);
	}

}
