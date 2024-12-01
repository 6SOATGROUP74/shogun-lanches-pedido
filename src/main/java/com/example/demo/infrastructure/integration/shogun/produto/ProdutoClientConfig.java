package com.example.demo.infrastructure.integration.shogun.produto;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoClientConfig {

    @Bean
    public ErrorDecoder specificErrorDecoder() {
        return new ProdutoErrorDecoder();
    }

}
