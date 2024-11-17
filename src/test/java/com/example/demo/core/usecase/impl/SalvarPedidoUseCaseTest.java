package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.pedido.SalvarPedidoAdapterPort;
import com.example.demo.core.domain.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class SalvarPedidoUseCaseTest {

    @Mock
    private SalvarPedidoAdapterPort salvarPedidoAdapterPort;

    @InjectMocks
    SalvarPedidoUseCase salvarPedidoUseCase;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_DeveRetornarUmPedidoValidor(){

        Pedido pedido = new Pedido();

        when(salvarPedidoAdapterPort.execute(eq(pedido))).thenReturn(new Pedido());

        assertNotNull(salvarPedidoUseCase.execute(pedido));
    }

}