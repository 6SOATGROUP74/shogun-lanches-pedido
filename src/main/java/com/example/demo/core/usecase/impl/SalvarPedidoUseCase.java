package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.usecase.interfaces.pedido.SalvarPedidoUseCasePort;
import com.example.demo.adapter.gateway.interfaces.pedido.SalvarPedidoAdapterPort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SalvarPedidoUseCase implements SalvarPedidoUseCasePort {

    private static final Logger logger = LogManager.getLogger(SalvarPedidoUseCase.class);

    private final SalvarPedidoAdapterPort salvarPedidoAdapterPort;

    public SalvarPedidoUseCase(SalvarPedidoAdapterPort salvarPedidoAdapterPort) {
        this.salvarPedidoAdapterPort = salvarPedidoAdapterPort;
    }

    @Override
    public Pedido execute(Pedido pedido) {
        logger.info("m=execute, msg=Persistindo no base de dados o pedido={}", pedido);
        return salvarPedidoAdapterPort.execute(pedido);
    }
}
