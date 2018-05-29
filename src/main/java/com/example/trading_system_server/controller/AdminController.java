package com.example.trading_system_server.controller;

import com.example.trading_system_server.service.FcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AdminController {

	@GetMapping("/")
	public String index() {
		return "helldddo";
	}

	@Autowired
	private FcmService fcmService;

	@GetMapping("/test")
	public void test() throws IOException {
		fcmService.test();
	}

}
