package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Pedido;
import com.example.demo.adapter.gateway.interfaces.pedido.ListarPedidosAdapterPort;
import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.presenter.PedidoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarPedidoAdapter implements ListarPedidosAdapterPort {

    private final PedidoRepository pedidoRepository;

    public ListarPedidoAdapter(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> listarTodosPedidos() {
        return PedidoEntityMapper.INSTANCE.mapFrom(pedidoRepository.findAll());
    }

    @Override
    public List<Pedido> listarPedidosOrdenados() {
        return PedidoEntityMapper.INSTANCE.mapFrom(pedidoRepository.ordenaPedidos());
    }

    @Override
    public Pedido buscarPedidoPorCodReferencia(String codReferencia) {
        return PedidoEntityMapper.INSTANCE.mapFrom(pedidoRepository.findByCodReferenciaPedido(codReferencia));
    }
}
