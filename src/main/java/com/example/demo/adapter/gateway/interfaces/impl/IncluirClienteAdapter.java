package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Cliente;
import com.example.demo.adapter.gateway.interfaces.cliente.IncluirClienteAdapterPort;
import com.example.demo.infrastructure.repository.ClienteRepository;
import com.example.demo.infrastructure.repository.presenter.ClienteEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IncluirClienteAdapter implements IncluirClienteAdapterPort {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente execute(Cliente cliente) {
        return ClienteEntityMapper.INSTANCE.mapFrom(
                clienteRepository.save(ClienteEntityMapper.INSTANCE.mapFrom(cliente)));
    }
}
