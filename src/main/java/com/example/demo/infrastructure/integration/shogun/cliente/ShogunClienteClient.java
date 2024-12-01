package com.example.demo.infrastructure.integration.shogun.cliente;

import com.example.demo.infrastructure.integration.shogun.produto.ProdutoClientConfig;
import com.example.demo.infrastructure.integration.shogun.produto.ProdutoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "ShogunClienteClient",
        url = "${shogun.lanches.cliente.url}",
        configuration = ProdutoClientConfig.class)
public interface ShogunClienteClient {

    @GetMapping(value = "/v1/cliente/{clienteId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ClienteResponse buscaPorId(@PathVariable String clienteId);

}
