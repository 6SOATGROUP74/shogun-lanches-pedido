package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.adapter.controller.request.pedido.mapper.PedidoMapper;
import com.example.demo.core.domain.Pedido;
import com.example.demo.adapter.gateway.interfaces.pedido.SalvarPedidoAdapterPort;
import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.presenter.PedidoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarPedidoAdapter implements SalvarPedidoAdapterPort {

    private final PedidoRepository repository;

    @Autowired
    public SalvarPedidoAdapter(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido execute(Pedido pedido) {
       return PedidoMapper.INSTANCE.mapFrom(repository.save(PedidoEntityMapper.INSTANCE.mapFrom(pedido)));
    }
}
