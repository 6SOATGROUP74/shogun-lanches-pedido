package com.example.demo.adapter.gateway.interfaces.pedido;

import com.example.demo.core.domain.Pedido;

public interface PedidoEmPreparacaoAdapterPort {
    Pedido execute(Long idPedido);
}
