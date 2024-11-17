package com.example.demo.adapter.presenter.produto;

import com.example.demo.adapter.controller.response.produto.ProdutoResponse;
import com.example.demo.core.domain.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProdutoResponseMapper {

    ProdutoResponseMapper INSTANCE = Mappers.getMapper(ProdutoResponseMapper.class);

    ProdutoResponse mapFrom(Produto produto);
    List<ProdutoResponse> mapFrom(List<Produto> produto);
}
