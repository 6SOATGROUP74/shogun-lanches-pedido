package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import static com.example.demo.mocks.PedidoHelper.gerarPedido;
import static com.example.demo.mocks.PedidoHelper.gerarPedidoEntity;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SalvarPedidoAdapterTest {

    PedidoRepository pedidoRepository = mock(PedidoRepository.class);
    SalvarPedidoAdapter salvarPedidoAdapter = new SalvarPedidoAdapter(pedidoRepository);

    @Test
    void deveSalvarPedidoComSucesso(){
        Pedido pedido = gerarPedido(StatusPedido.EM_PREPARACAO.name());
        PedidoEntity pedidoEntity = gerarPedidoEntity(StatusPedido.EM_PREPARACAO);

        when(pedidoRepository.saveAndFlush(any(PedidoEntity.class))).thenReturn(pedidoEntity);

        var result = salvarPedidoAdapter.execute(pedido);

        verify(pedidoRepository, times(1)).saveAndFlush(any());
    }
}