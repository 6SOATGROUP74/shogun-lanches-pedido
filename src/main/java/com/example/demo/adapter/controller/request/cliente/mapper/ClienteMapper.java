package com.example.demo.adapter.controller.request.cliente.mapper;

import com.example.demo.adapter.controller.request.cliente.ClienteRequest;
import com.example.demo.adapter.controller.response.pedido.ClienteResponse;
import com.example.demo.core.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente mapFrom(ClienteRequest clienteRequest);
    ClienteResponse mapFrom(Cliente cliente);
}
