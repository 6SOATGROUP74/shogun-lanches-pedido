package com.example.demo.exceptions;

public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException(final String message){
        super(message);
    };

    public ProdutoNotFoundException(final String message, final Throwable cause){
        super(message, cause);
    };
}
