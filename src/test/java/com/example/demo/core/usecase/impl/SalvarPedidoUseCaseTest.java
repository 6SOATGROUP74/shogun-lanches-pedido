package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.pedido.SalvarPedidoAdapterPort;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import static com.example.demo.mocks.PedidoHelper.gerarPedido;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SalvarPedidoUseCaseTest {

    SalvarPedidoAdapterPort salvarPedidoAdapterPort = mock(SalvarPedidoAdapterPort.class);

    @Test
    public void deveSalvarPedidoComSucesso(){
        Pedido pedido = gerarPedido(StatusPedido.EM_PREPARACAO.name());

        when(salvarPedidoAdapterPort.execute(pedido)).thenReturn(pedido);

        salvarPedidoAdapterPort.execute(pedido);

        verify(salvarPedidoAdapterPort, times(1)).execute(any());
    }
}