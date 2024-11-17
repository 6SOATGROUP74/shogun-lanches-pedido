package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.usecase.interfaces.pedido.BuscarPedidoUseCasePort;
import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import com.example.demo.infrastructure.repository.presenter.PedidoEntityMapper;

import java.util.Optional;

public class BuscarPedidoUseCase implements BuscarPedidoUseCasePort {

    private final PedidoRepository pedidoRepository;

    public BuscarPedidoUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido buscarPorId(Long idPedido) {
        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(idPedido);
        return PedidoEntityMapper.INSTANCE.mapFrom(pedidoEntity.get());
    }
}
