package com.example.demo.adapter.gateway.interfaces.pedido;

import com.example.demo.core.domain.Pedido;

public interface SalvarPedidoAdapterPort {
    Pedido execute(Pedido pedido);
}