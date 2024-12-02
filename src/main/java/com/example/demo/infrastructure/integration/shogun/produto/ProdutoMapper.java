package com.example.demo.infrastructure.integration.shogun.produto;

import com.example.demo.adapter.controller.request.produto.ProdutoRequest;
import com.example.demo.core.domain.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    Produto mapFrom(ProdutoRequest produtoRequest);
    Produto mapFrom(ProdutoResponse produtoResponse);
}
