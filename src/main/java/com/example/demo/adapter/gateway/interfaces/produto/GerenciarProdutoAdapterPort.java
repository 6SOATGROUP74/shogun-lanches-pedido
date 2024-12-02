package com.example.demo.adapter.gateway.interfaces.produto;

import com.example.demo.core.domain.Produto;

import java.util.List;

public interface GerenciarProdutoAdapterPort {
    Produto buscarProdutoPorId(Long id);
}
