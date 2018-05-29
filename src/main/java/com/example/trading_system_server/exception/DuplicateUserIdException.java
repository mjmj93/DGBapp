package com.example.trading_system_server.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class DuplicateUserIdException extends RuntimeException {

    public DuplicateUserIdException(String message) {
        super(message);
    }

    public DuplicateUserIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
