package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.controller.PedidoController;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.usecase.interfaces.pedido.ListarPedidosUseCasePort;
import com.example.demo.adapter.gateway.interfaces.pedido.ListarPedidosAdapterPort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ListarPedidosUseCase implements ListarPedidosUseCasePort {

    private final ListarPedidosAdapterPort listarPedidosAdapterPort;

    public ListarPedidosUseCase(ListarPedidosAdapterPort listarPedidosAdapterPort) {
        this.listarPedidosAdapterPort = listarPedidosAdapterPort;
    }

    @Override
    public List<Pedido> execute(){
        logger.info("m=execute, msg=Lista pedidos aleatoriamente");
        return listarPedidosAdapterPort.listarTodosPedidos();
    }

    @Override
    public List<Pedido> listarOrdenados() {
        logger.info("m=listarOrdenados, msg=Lista pedidos ordenados (PRONTO > EM_PREPARACAO > RECEBIDO)");
        return listarPedidosAdapterPort.listarPedidosOrdenados();
    }

    @Override
    public Pedido listarPorCodReferencia(String codReferencia) {
        logger.info("m=listarPorCodReferencia, msg=Lista pedido por codReferencia={}", codReferencia);
        return listarPedidosAdapterPort.buscarPedidoPorCodReferencia(codReferencia);
    }

    private static final Logger logger = LogManager.getLogger(PedidoController.class);
}
