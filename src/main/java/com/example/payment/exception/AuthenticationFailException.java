package com.example.payment.exception;

public class AuthenticationFailException extends Exception{
    public AuthenticationFailException(String msg){
        super(msg);
    }
}
