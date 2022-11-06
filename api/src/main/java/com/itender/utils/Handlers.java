package com.itender.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.itender.api.response.ErrorResponse;
import com.itender.exception.ITenderException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
@SuppressWarnings("MethodMayBeStatic")
public class Handlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ITenderException.class)
    public ResponseEntity<ErrorResponse> handleITenderException(ITenderException exception) {
        log.error(exception.getMessage(), exception);

        if (exception.getErrorCode() != null) {
            return new ResponseEntity<>(
                    new ErrorResponse(exception.getErrorCode().value(), exception.getMessage()),
                    exception.getErrorCode());
        } else {
            if (exception.getCause() != null) {
                log.error(exception.getCause().getMessage(), exception.getCause());
            }
            return new ResponseEntity<>(
                    new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
