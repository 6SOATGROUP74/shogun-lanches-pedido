package com.example.demo.infrastructure.integration.shogun.cliente;

import com.example.demo.core.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente mapFrom(ClienteResponse clienteResponse);
}
