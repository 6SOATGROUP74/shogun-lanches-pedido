package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.pedido.AtualizarPedidoAdapterPort;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.usecase.interfaces.pedido.BuscarPedidoUseCasePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class AlterarPedidoUseCaseTest {

    @Mock
    private AtualizarPedidoAdapterPort atualizarPedidoAdapterPort;

    @Mock
    private BuscarPedidoUseCasePort buscarPedidoUseCasePort;

    @InjectMocks
    AlterarPedidoUseCase alterarPedidoUseCase;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_DeveRetornarUmPedidoValido(){

        Pedido pedido = new Pedido();
        pedido.setNumeroPedido(2L);
        when(buscarPedidoUseCasePort.buscarPorId(anyLong())).thenReturn(pedido);
        when(atualizarPedidoAdapterPort.execute(eq(pedido))).thenReturn(new Pedido());

        assertNotNull(alterarPedidoUseCase.execute(pedido));

    }

}