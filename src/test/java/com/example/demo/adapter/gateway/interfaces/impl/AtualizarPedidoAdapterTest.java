package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import static com.example.demo.mocks.PedidoHelper.gerarPedido;
import static com.example.demo.mocks.PedidoHelper.gerarPedidoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AtualizarPedidoAdapterTest {

    PedidoRepository pedidoRepository = mock(PedidoRepository.class);
    AtualizarPedidoAdapter atualizarPedidoAdapter = new AtualizarPedidoAdapter(pedidoRepository);

    @Test
    public void deveAtualizarPedidoComSucesso(){
        Pedido pedido = gerarPedido(StatusPedido.EM_PREPARACAO.name());
        PedidoEntity pedidoEntity = gerarPedidoEntity(StatusPedido.EM_PREPARACAO);
        ArgumentCaptor<PedidoEntity> captorPedido = ArgumentCaptor.forClass(PedidoEntity.class);

        when(pedidoRepository.save(captorPedido.capture())).thenReturn(pedidoEntity);

        atualizarPedidoAdapter.execute(pedido);

        verify(pedidoRepository, times(1)).save(any());
        Assertions.assertEquals(pedido.getNumeroPedido(), captorPedido.getValue().getNumeroPedido());
    }
}