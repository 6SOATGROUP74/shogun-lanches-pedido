package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Pedido;
import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AtualizarPedidoAdapterTest {

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private AtualizarPedidoAdapter adapter;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_NaoDeveRetornarException() {
        when(repository.save(any(PedidoEntity.class))).thenReturn(new PedidoEntity());
        assertDoesNotThrow(() -> adapter.execute(any(Pedido.class)));
    }

}