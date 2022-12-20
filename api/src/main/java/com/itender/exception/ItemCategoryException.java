package com.itender.exception;

import org.springframework.http.HttpStatus;

public class ItemCategoryException extends ITenderException{

    public ItemCategoryException(String message) {
        super(message);
    }

    public ItemCategoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemCategoryException(String message, HttpStatus errorCode) {
        super(message, errorCode);
    }

}
