package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.pedido.SalvarPedidoAdapterPort;
import com.example.demo.core.domain.Pedido;
import com.example.demo.mocks.PedidoHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SalvarPedidoUseCaseTest {

    private SalvarPedidoAdapterPort salvarPedidoAdapterPort;
    private SalvarPedidoUseCase salvarPedidoUseCase;

    @BeforeEach
    void setUp() {
        salvarPedidoAdapterPort = mock(SalvarPedidoAdapterPort.class);
        salvarPedidoUseCase = new SalvarPedidoUseCase(salvarPedidoAdapterPort);
    }

    @Test
    void deveSalvarPedidoComSucesso() {
        var pedidos = PedidoHelper.gerarPedido(null);

        when(salvarPedidoAdapterPort.execute(any(Pedido.class))).thenReturn(pedidos);

        Pedido resultado = salvarPedidoUseCase.execute(pedidos);

        assertThat(resultado).isNotNull();

        verify(salvarPedidoAdapterPort, times(1)).execute(any(Pedido.class));
    }
}