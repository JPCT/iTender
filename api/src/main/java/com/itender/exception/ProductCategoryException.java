package com.itender.exception;

import org.springframework.http.HttpStatus;

public class ProductCategoryException extends ITenderException{

    public ProductCategoryException(String message) {
        super(message);
    }

    public ProductCategoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductCategoryException(String message, HttpStatus errorCode) {
        super(message, errorCode);
    }

}
