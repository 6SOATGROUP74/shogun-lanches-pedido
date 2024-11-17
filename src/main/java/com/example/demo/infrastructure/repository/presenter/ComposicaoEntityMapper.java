package com.example.demo.infrastructure.repository.presenter;

import com.example.demo.core.domain.Composicao;
import com.example.demo.infrastructure.repository.entity.ComposicaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ComposicaoEntityMapper {

    ComposicaoEntityMapper INSTANCE = Mappers.getMapper(ComposicaoEntityMapper.class);

    @Mapping(source = "nomeProduto", target = "produto.nome")
    @Mapping(source = "categoria", target = "produto.categoria")
    @Mapping(source = "idProduto", target = "produto.idProduto")
    ComposicaoEntity mapFrom(Composicao composicao);
    List<ComposicaoEntity> mapFroms(List<Composicao> composicao);

    @Mapping(target = "nomeProduto", source = "produto.nome")
    @Mapping(target = "categoria", source = "produto.categoria")
    @Mapping(target = "idProduto", source = "produto.idProduto")
    Composicao mapFrom(ComposicaoEntity composicaoEntity);
    List<Composicao> mapFrom(List<ComposicaoEntity> composicaoEntity);

}
