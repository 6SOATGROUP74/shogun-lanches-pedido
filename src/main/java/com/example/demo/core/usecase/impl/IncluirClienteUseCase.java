package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Cliente;
import com.example.demo.exceptions.ClienteDuplicadoException;
import com.example.demo.core.usecase.interfaces.cliente.IncluirClienteUseCasePort;
import com.example.demo.adapter.gateway.interfaces.cliente.IncluirClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;

import java.util.Objects;

public class IncluirClienteUseCase implements IncluirClienteUseCasePort {

    private final IncluirClienteAdapterPort incluirClienteAdapterPort;
    private final RecuperarClienteAdapterPort recuperarClienteAdapterPort;


    public IncluirClienteUseCase(RecuperarClienteAdapterPort recuperarClienteAdapterPort,
                                 IncluirClienteAdapterPort incluirClienteAdapterPort) {
        this.recuperarClienteAdapterPort = recuperarClienteAdapterPort;
        this.incluirClienteAdapterPort = incluirClienteAdapterPort;
    }

    @Override
    public Cliente execute(Cliente cliente) {

        final var result = recuperarClienteAdapterPort.execute(cliente.getCpf());

        if(Objects.nonNull(result)){
            throw new ClienteDuplicadoException("Cliente já existe na base de dados e cognito.");
        }

        return incluirClienteAdapterPort.execute(cliente);
    }
}
