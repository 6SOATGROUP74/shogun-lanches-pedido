package com.example.demo.infrastructure.integration.shogun.produto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "ShogunProdutoClient",
        url = "${shogun.lanches.produto.url}")
public interface ShogunProdutoClient {

    @GetMapping(value = "/v1/produtos/{produtoId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ProdutoResponse buscaPorId(@PathVariable Long produtoId);

}
