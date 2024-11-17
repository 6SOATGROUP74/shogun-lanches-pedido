package com.example.demo.core.usecase.interfaces.pedido;

import com.example.demo.core.domain.Pedido;

public interface SalvarPedidoUseCasePort {
   Pedido execute(Pedido pedido);
}