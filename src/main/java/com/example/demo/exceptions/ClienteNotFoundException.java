package com.example.demo.exceptions;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(final String message){
        super(message);
    };

}
