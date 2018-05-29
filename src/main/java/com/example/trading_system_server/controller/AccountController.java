package com.example.trading_system_server.controller;

import com.example.trading_system_server.model.Account;
import com.example.trading_system_server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/signup")
	public Account saveAccount(@RequestBody Account account) {
		return accountService.join(account);
	}

	@GetMapping("/signin")
	public Account loginAccount(@RequestBody Account account) {
		return accountService.login(account);
	}

	@PostMapping("/balance")
	public Account updateAccount(@RequestBody Account account) {
		return accountService.updateBalance(account);
	}
}
