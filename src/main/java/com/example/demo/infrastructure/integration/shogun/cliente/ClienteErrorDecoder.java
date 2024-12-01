package com.example.demo.infrastructure.integration.shogun.cliente;

import feign.Response;
import feign.codec.ErrorDecoder;

public class ClienteErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        return null;
    }
}
