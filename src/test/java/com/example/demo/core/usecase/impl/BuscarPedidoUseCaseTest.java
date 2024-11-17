package com.example.demo.core.usecase.impl;

import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class BuscarPedidoUseCaseTest {

    @Mock
    PedidoRepository pedidoRepository;

    @InjectMocks
    BuscarPedidoUseCase buscarPedidoUseCase;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarPorId_DeveRetornaUmPedido(){

        when(pedidoRepository.findById(anyLong())).thenReturn(Optional.of(new PedidoEntity()));

        assertNotNull(buscarPedidoUseCase.buscarPorId(anyLong()));
    }

}