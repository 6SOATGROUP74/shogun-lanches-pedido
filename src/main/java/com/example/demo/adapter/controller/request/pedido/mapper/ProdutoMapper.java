package com.example.demo.adapter.controller.request.pedido.mapper;

import com.example.demo.adapter.controller.request.produto.ProdutoRequest;
import com.example.demo.core.domain.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    Produto mapFrom(ProdutoRequest produtoRequest);
}
