package com.example.demo.core.usecase.impl;


import com.example.demo.core.domain.StatusPedido;
import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import static com.example.demo.mocks.PedidoHelper.gerarPedidoEntity;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

class BuscarPedidoUseCaseTest {

    PedidoRepository pedidoRepository = mock(PedidoRepository.class);
    BuscarPedidoUseCase buscarPedidoUseCase = new BuscarPedidoUseCase(pedidoRepository);

    @Test
    public void deveBuscarPedidoComSucesso(){
        Long pedidoId = 1L;
        PedidoEntity pedidoEntity = gerarPedidoEntity(StatusPedido.EM_PREPARACAO);

        when(pedidoRepository.findById(pedidoId)).thenReturn(Optional.of(pedidoEntity));

        buscarPedidoUseCase.buscarPorId(pedidoId);

        verify(pedidoRepository, times(1)).findById(anyLong());
    }

}