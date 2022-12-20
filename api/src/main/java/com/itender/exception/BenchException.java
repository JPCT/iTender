package com.itender.exception;

import org.springframework.http.HttpStatus;

public class BenchException extends ITenderException{

    public BenchException(String message) {
        super(message);
    }

    public BenchException(String message, Throwable cause) {
        super(message, cause);
    }

    public BenchException(String message, HttpStatus errorCode) {
        super(message, errorCode);
    }

}
