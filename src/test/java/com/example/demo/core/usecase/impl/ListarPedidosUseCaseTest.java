package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.pedido.ListarPedidosAdapterPort;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import static com.example.demo.mocks.PedidoHelper.gerarPedido;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

class ListarPedidosUseCaseTest {

    ListarPedidosAdapterPort listarPedidosAdapterPort = mock(ListarPedidosAdapterPort.class);
    ListarPedidosUseCase listarPedidosUseCase = new ListarPedidosUseCase(listarPedidosAdapterPort);

    @Test
    public void deveListarPedidosComSucesso(){
        Pedido pedido = gerarPedido(StatusPedido.EM_PREPARACAO.name());

        when(listarPedidosAdapterPort.listarTodosPedidos()).thenReturn(Arrays.asList(pedido));

        listarPedidosUseCase.execute();

        verify(listarPedidosAdapterPort, times(1)).listarTodosPedidos();
    }

    @Test
    public void deveListarPedidosOrdenadosComSucesso(){
        Pedido pedido = gerarPedido(StatusPedido.EM_PREPARACAO.name());

        when(listarPedidosAdapterPort.listarPedidosOrdenados()).thenReturn(Arrays.asList(pedido));

        listarPedidosUseCase.listarOrdenados();

        verify(listarPedidosAdapterPort, times(1)).listarPedidosOrdenados();
    }

    @Test
    public void deveListarPorCodReferenciaComSucesso(){
        Pedido pedido = gerarPedido(StatusPedido.EM_PREPARACAO.name());

        when(listarPedidosAdapterPort.buscarPedidoPorCodReferencia(pedido.getCodReferenciaPedido())).thenReturn(pedido);

        listarPedidosUseCase.listarPorCodReferencia(pedido.getCodReferenciaPedido());

        verify(listarPedidosAdapterPort, times(1)).buscarPedidoPorCodReferencia(anyString());
    }
}