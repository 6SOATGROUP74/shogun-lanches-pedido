package com.example.demo.adapter.gateway.interfaces.impl;


import com.example.demo.core.domain.Cliente;
import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.infrastructure.integration.shogun.cliente.ClienteMapper;
import com.example.demo.infrastructure.integration.shogun.cliente.ShogunClienteClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RecuperarClienteAdapter implements RecuperarClienteAdapterPort {

    private final ShogunClienteClient client;

    @Override
    public Cliente recuperarPorId(String clientId) {
        return ClienteMapper.INSTANCE.mapFrom(client.buscaPorId(clientId));
    }

}
