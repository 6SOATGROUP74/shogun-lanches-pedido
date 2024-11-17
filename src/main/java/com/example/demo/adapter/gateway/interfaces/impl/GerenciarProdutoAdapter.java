package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Produto;
import com.example.demo.adapter.gateway.interfaces.produto.GerenciarProdutoAdapterPort;
import com.example.demo.infrastructure.repository.ProdutoRepository;
import com.example.demo.infrastructure.repository.presenter.ProdutoEntityMapper;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GerenciarProdutoAdapter implements GerenciarProdutoAdapterPort {

    private static final Logger logger = LogManager.getLogger(GerenciarProdutoAdapter.class);

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto salvar(Produto produto) {
        var produtoEntity = ProdutoEntityMapper.INSTANCE.mapFrom(produto);
        return ProdutoEntityMapper.INSTANCE.mapFrom(produtoRepository.save(produtoEntity));
    }

    @Override
    public List<Produto> buscarProdutoPorCategoria(String categoria) {
        logger.info("m=buscarProdutoPorCategoria, msg=Buscando produto por categoria, categoria={}", categoria);
        return ProdutoEntityMapper.INSTANCE.mapFrom(produtoRepository.findByCategoriaAndStatus(categoria,true));
    }

    @Override
    public Produto buscarProdutoPorId(Long id) {
        logger.info("m=buscarProdutoPorId, msg=Buscando produto por id, id={}", id);
        return ProdutoEntityMapper.INSTANCE.mapFrom(produtoRepository.findById(id).orElse(null));
    }
}
