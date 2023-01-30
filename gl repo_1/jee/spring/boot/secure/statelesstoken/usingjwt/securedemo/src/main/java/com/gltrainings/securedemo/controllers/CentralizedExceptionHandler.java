package com.gltrainings.securedemo.controllers;

import com.gltrainings.securedemo.exceptions.IncorrectCredentialsException;
import com.gltrainings.securedemo.exceptions.InvalidTokenException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleNotValid(ConstraintViolationException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({InvalidTokenException.class, IncorrectCredentialsException.class})
    public String handleNotAuthorized(Exception e){
        e.printStackTrace();
        return e.getMessage();
    }


}
