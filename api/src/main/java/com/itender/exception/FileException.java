package com.itender.exception;

import org.springframework.http.HttpStatus;

public class FileException extends ITenderException {

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileException(String message, HttpStatus errorCode) {
        super(message, errorCode);
    }

}
