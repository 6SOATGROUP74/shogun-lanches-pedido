package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Produto;
import com.example.demo.adapter.gateway.interfaces.produto.GerenciarProdutoAdapterPort;
import com.example.demo.infrastructure.integration.shogun.produto.ProdutoMapper;
import com.example.demo.infrastructure.integration.shogun.produto.ShogunProdutoClient;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GerenciarProdutoAdapter implements GerenciarProdutoAdapterPort {

    private static final Logger logger = LogManager.getLogger(GerenciarProdutoAdapter.class);

    private final ShogunProdutoClient client;

    @Override
    public Produto buscarProdutoPorId(Long id) {
        logger.info("m=buscarProdutoPorId, msg=Buscando produto por id, id={}", id);
        return ProdutoMapper.INSTANCE.mapFrom(client.buscaPorId(id));
    }
}
