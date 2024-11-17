package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ListarPedidoAdapterTest {

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private ListarPedidoAdapter listarPedidoAdapter;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarTodosPedidos_NaoDeveRetornarException() {
        when(repository.findAll())
                .thenReturn(List.of(new PedidoEntity()));

        assertDoesNotThrow(() -> listarPedidoAdapter.listarTodosPedidos());
    }

    @Test
    void listarPedidosOrdenados_NaoDeveRetornarException() {
        when(repository.ordenaPedidos())
                .thenReturn(List.of(new PedidoEntity()));

        assertDoesNotThrow(() -> listarPedidoAdapter.listarPedidosOrdenados());
    }

    @Test
    void buscarPedidoPorCodReferencia_NaoDeveRetornarException() {
        when(repository.findByCodReferenciaPedido(anyString()))
                .thenReturn(new PedidoEntity());

        assertDoesNotThrow(() -> listarPedidoAdapter.buscarPedidoPorCodReferencia(anyString()));
    }

}