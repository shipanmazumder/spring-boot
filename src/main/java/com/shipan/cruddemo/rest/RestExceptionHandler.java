package com.shipan.cruddemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException ex) {
        ErrorResponse er = new ErrorResponse();
        er.setCode(HttpStatus.NOT_FOUND.value());
        er.setMessage(ex.getMessage());
        er.setStatus(false);
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse er = new ErrorResponse();
        er.setCode(HttpStatus.BAD_REQUEST.value());
        er.setMessage(ex.getMessage());
        er.setStatus(false);
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }
}
