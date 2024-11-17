package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.usecase.interfaces.pedido.AlterarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.BuscarPedidoUseCasePort;
import com.example.demo.adapter.gateway.interfaces.pedido.AtualizarPedidoAdapterPort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AlterarPedidoUseCase implements AlterarPedidoUseCasePort {

    private final AtualizarPedidoAdapterPort atualizarPedidoAdapterPort;
    private final BuscarPedidoUseCasePort buscarPedidoUseCasePort;


    public AlterarPedidoUseCase(AtualizarPedidoAdapterPort atualizarPedidoAdapterPort, BuscarPedidoUseCasePort buscarPedidoUseCasePort) {
        this.atualizarPedidoAdapterPort = atualizarPedidoAdapterPort;
        this.buscarPedidoUseCasePort = buscarPedidoUseCasePort;
    }

    @Override
    public Pedido execute(Pedido pedido) {
        Pedido pedidoEncontrado = buscarPedidoUseCasePort.buscarPorId(pedido.getNumeroPedido());
        pedidoEncontrado.setEtapa(pedido.getEtapa());
        pedidoEncontrado.setDataMudancaEtapa(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return atualizarPedidoAdapterPort.execute(pedidoEncontrado);
    }
}
