package com.example.demo.adapter.gateway.interfaces.impl;


import com.example.demo.core.domain.Cliente;
import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.infrastructure.repository.ClienteRepository;
import com.example.demo.infrastructure.repository.presenter.ClienteEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RecuperarClienteAdapter implements RecuperarClienteAdapterPort {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente execute(String documentoCliente) {
        return ClienteEntityMapper.INSTANCE.mapFrom(clienteRepository.findByCpf(documentoCliente));
    }

    @Override
    public Cliente recuperarPorId(Long clientId) {
        return ClienteEntityMapper.INSTANCE.mapFrom(clienteRepository.findById(clientId).get());
    }

}
