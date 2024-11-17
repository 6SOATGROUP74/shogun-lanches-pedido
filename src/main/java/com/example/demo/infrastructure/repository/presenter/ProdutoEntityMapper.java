package com.example.demo.infrastructure.repository.presenter;

import com.example.demo.core.domain.Produto;
import com.example.demo.infrastructure.repository.entity.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProdutoEntityMapper {

    ProdutoEntityMapper INSTANCE = Mappers.getMapper(ProdutoEntityMapper.class);

    ProdutoEntity mapFrom(Produto produto);
    Produto mapFrom(ProdutoEntity produto);
    List<Produto> mapFrom(List<ProdutoEntity> produto);


}
