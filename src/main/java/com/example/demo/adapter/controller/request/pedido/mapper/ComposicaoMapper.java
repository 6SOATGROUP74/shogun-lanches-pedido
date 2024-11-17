package com.example.demo.adapter.controller.request.pedido.mapper;

import com.example.demo.adapter.controller.request.pedido.ComposicaoRequest;
import com.example.demo.core.domain.Composicao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface ComposicaoMapper {

    ComposicaoMapper INSTANCE = Mappers.getMapper(ComposicaoMapper.class);

    Composicao mapFrom(ComposicaoRequest composicaoRequest);
    List<Composicao> mapFrom(List<ComposicaoRequest> composicaoRequest);
}
