package com.itender.exception;

import org.springframework.http.HttpStatus;

public class StoreException extends ITenderException {

    public StoreException(String message) {
        super(message);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreException(String message, HttpStatus errorCode) {
        super(message, errorCode);
    }

}
