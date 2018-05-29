package com.example.trading_system_server.service;

import com.example.trading_system_server.exception.DuplicateUserIdException;
import com.example.trading_system_server.exception.InvalidPasswordException;
import com.example.trading_system_server.model.Account;
import com.example.trading_system_server.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public Account join(Account account) {
		if(null != accountRepository.findByUserId(account.getUserId())) {
			throw new DuplicateUserIdException("User ID is duplicated.");
		}

		return accountRepository.save(account);
	}


	public Account login(Account account) {

		Account testAccount = accountRepository.findByUserIdAndPassword(account.getUserId(),account.getPassword());
		if(null == testAccount) {
			throw new InvalidPasswordException("User ID or password is incorrect.");
		}

		return testAccount;
	}


	public Account updateBalance(Account account) {
		Account updated = accountRepository.findByUserId(account.getUserId());
		updated.setBlance(account.getBlance());
		return updated;
	}



}
