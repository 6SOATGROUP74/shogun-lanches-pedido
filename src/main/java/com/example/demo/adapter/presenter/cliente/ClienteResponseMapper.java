package com.example.demo.adapter.presenter.cliente;

import com.example.demo.adapter.controller.response.cliente.ClienteResponse;
import com.example.demo.core.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteResponseMapper {

    ClienteResponseMapper INSTANCE = Mappers.getMapper(ClienteResponseMapper.class);

    @Mapping(target = "dataCadastro", source = "dataCadastro")
    ClienteResponse mapFrom(Cliente cliente);

}
