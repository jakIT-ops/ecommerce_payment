package com.example.payment.exception;

public class ProductNotExistException extends Exception{
    public ProductNotExistException(String msg){
        super(msg);
    }
}
