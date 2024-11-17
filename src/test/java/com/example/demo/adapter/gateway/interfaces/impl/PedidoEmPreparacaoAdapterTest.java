package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class PedidoEmPreparacaoAdapterTest {

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private PedidoEmPreparacaoAdapter pedidoEmPreparacaoAdapter;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_NaoDeveRetornarException() {
        when(repository.findById(anyLong()))
                .thenReturn(Optional.of(new PedidoEntity()));

        when(repository.save(any(PedidoEntity.class)))
                .thenReturn(new PedidoEntity());

        assertDoesNotThrow(() -> pedidoEmPreparacaoAdapter.execute(anyLong()));
    }
}