package com.example.demo.core.usecase.interfaces.pedido;

import com.example.demo.core.domain.Pedido;

public interface BuscarPedidoUseCasePort {
    Pedido buscarPorId(Long id);
}
