package com.itender.exception;

import org.springframework.http.HttpStatus;

public class ProductException extends ITenderException{

    public ProductException(String message) {
        super(message);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductException(String message, HttpStatus errorCode) {
        super(message, errorCode);
    }

}
