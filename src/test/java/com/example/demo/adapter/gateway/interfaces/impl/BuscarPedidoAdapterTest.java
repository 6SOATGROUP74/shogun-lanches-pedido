package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import static com.example.demo.mocks.PedidoHelper.gerarPedido;
import static com.example.demo.mocks.PedidoHelper.gerarPedidoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

class BuscarPedidoAdapterTest {

    PedidoRepository pedidoRepository = mock(PedidoRepository.class);
    BuscarPedidoAdapter buscarPedidoAdapter = new BuscarPedidoAdapter(pedidoRepository);

    @Test
    public void deverBuscarPedidoComSucesso() {
        Long pedidoId = 1L;
        Pedido pedido = gerarPedido(StatusPedido.EM_PREPARACAO.name());
        PedidoEntity pedidoEntity = gerarPedidoEntity(StatusPedido.EM_PREPARACAO);

        when(pedidoRepository.findById(pedidoId)).thenReturn(Optional.of(pedidoEntity));

        var result = buscarPedidoAdapter.execute(pedidoId);

        verify(pedidoRepository, times(1)).findById(anyLong());
        Assertions.assertEquals(pedido.getNumeroPedido(), result.getNumeroPedido());
    }

    @Test
    public void deveRetornarExcessaoQuandoNaoEncontrarPedido(){
        Long pedidoId = 1L;
        when(pedidoRepository.findById(pedidoId)).thenThrow(new NoSuchElementException("No value present"));

        Pedido result = null;
        try {
           result = buscarPedidoAdapter.execute(pedidoId);
           Assertions.fail();
        } catch (Exception e) {
            verify(pedidoRepository, times(1)).findById(anyLong());
            Assertions.assertNull(result);
        }
    }
}