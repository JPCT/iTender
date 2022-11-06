package com.itender.exception;

import org.springframework.http.HttpStatus;

public class ITenderException extends Exception{

    private HttpStatus errorCode;

    public ITenderException(String message) {
        super(message);
    }

    public ITenderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ITenderException(String message, HttpStatus errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public HttpStatus getErrorCode() {
        return this.errorCode;
    }
}
