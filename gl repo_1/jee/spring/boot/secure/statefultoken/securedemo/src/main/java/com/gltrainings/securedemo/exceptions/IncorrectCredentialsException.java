package com.gltrainings.securedemo.exceptions;

public class IncorrectCredentialsException  extends RuntimeException{
    public IncorrectCredentialsException(String msg){
        super(msg);
    }
}
