package com.example.trading_system_server.exception;

public class InvalidPasswordException extends RuntimeException {

	public InvalidPasswordException(String message) {
		super(message);
	}

	public InvalidPasswordException(String message, Throwable cause) {
		super(message, cause);
	}
}
