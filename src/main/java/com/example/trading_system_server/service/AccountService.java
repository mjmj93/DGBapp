package com.example.trading_system_server.service;

import com.example.trading_system_server.exception.DuplicateUserIdException;
import com.example.trading_system_server.exception.InvalidPasswordException;
import com.example.trading_system_server.model.Account;
import com.example.trading_system_server.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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


	public Account login(String id, String pw) {

		Account testAccount = accountRepository.findByUserIdAndPassword(id,pw);
		if(null == testAccount) {
			throw new InvalidPasswordException("User ID or password is incorrect.");
		}

		return testAccount;
	}


	public Account updateBalance(int userId, int balance) {
		Account updated = accountRepository.findById(userId).get();
		updated.setBalance(balance);
		return updated;
	}

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account findById(int id) {
		return accountRepository.findById(id).get();
	}

	public Account findBySellerFlag(int sellerFlag){
		return accountRepository.findBySellerFlag(sellerFlag);
	}

}
