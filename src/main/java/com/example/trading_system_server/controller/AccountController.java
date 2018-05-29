package com.example.trading_system_server.controller;

import com.example.trading_system_server.model.Account;
import com.example.trading_system_server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping
	private List<Account> getAllAccounts() {
		return accountService.findAll();
	}

	@PostMapping("/signup")
	public Account saveAccount(@RequestBody Account account) {
		return accountService.join(account);
	}

	@PostMapping("/signin")
	public Account loginAccount(@RequestBody Account account) {
		return accountService.login(account.getUserId(), account.getPassword());
	}

	@PostMapping("/balance")
	public Account updateAccount(@RequestParam("userId") int userId, @RequestParam("balance") int balance) {
		return accountService.updateBalance(userId, balance);
	}
}
