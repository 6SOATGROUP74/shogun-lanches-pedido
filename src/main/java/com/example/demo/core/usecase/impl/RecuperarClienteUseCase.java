package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Cliente;
import com.example.demo.exceptions.ClienteNotFoundException;
import com.example.demo.core.usecase.interfaces.cliente.RecuperarClienteUseCasePort;
import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class RecuperarClienteUseCase implements RecuperarClienteUseCasePort {

    private static final Logger logger = LogManager.getLogger(RecuperarClienteUseCase.class);

    private final RecuperarClienteAdapterPort recuperarClienteAdapterPort;

    public RecuperarClienteUseCase(RecuperarClienteAdapterPort recuperarClienteAdapterPort) {
        this.recuperarClienteAdapterPort = recuperarClienteAdapterPort;
    }

    public Cliente recuperarPorId(String clienteId) throws ClienteNotFoundException {
        logger.info("m=recuperarPorId, msg=Recuperando cliente por clienteId, clienteId={}", clienteId);
        return recuperarClienteAdapterPort.recuperarPorId(clienteId);
    }
    
}
