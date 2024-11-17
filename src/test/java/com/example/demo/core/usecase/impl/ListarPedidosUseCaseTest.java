package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.pedido.ListarPedidosAdapterPort;
import com.example.demo.core.domain.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ListarPedidosUseCaseTest {

    @Mock
    ListarPedidosAdapterPort listarPedidosAdapterPort;

    @InjectMocks
    ListarPedidosUseCase listarPedidosUseCase;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_DeveExecutarComSucesso(){
        when(listarPedidosAdapterPort.listarTodosPedidos()).thenReturn(List.of(new Pedido()));
        assertDoesNotThrow(() -> listarPedidosUseCase.execute());
    }

    @Test
    void listarOrdenados_DeveExecutarComSucesso(){
        when(listarPedidosAdapterPort.listarPedidosOrdenados()).thenReturn(List.of(new Pedido()));
        assertDoesNotThrow(() -> listarPedidosUseCase.listarOrdenados());
    }

    @Test
    void listarPorCodReferencia_DeveExecutarComSucesso(){
        when(listarPedidosAdapterPort.buscarPedidoPorCodReferencia(anyString())).thenReturn(new Pedido());
        assertDoesNotThrow(() -> listarPedidosUseCase.listarPorCodReferencia(anyString()));
    }


}