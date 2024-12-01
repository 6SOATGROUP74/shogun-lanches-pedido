package com.example.demo.infrastructure.integration.shogun.cliente;

import com.example.demo.infrastructure.integration.shogun.produto.ProdutoErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteClientConfig {

    @Bean
    public ErrorDecoder specificErrorDecoder() {
        return new ClienteErrorDecoder();
    }

}
