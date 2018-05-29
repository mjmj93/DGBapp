package com.example.trading_system_server.model.fcm;

import lombok.Data;

@Data
public class Message {
	private String token;

	private Notification notification;
}
