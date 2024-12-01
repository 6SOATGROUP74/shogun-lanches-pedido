package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import static com.example.demo.mocks.PedidoHelper.gerarPedidoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

class PedidoEmPreparacaoAdapterTest {

    PedidoRepository pedidoRepository = mock(PedidoRepository.class);
    PedidoEmPreparacaoAdapter pedidoEmPreparacaoAdapter = new PedidoEmPreparacaoAdapter(pedidoRepository);

    @Test
    public void deveGerarPedidoEmPreparacaoComSucesso() {
        Long pedidoId = 1L;
        PedidoEntity pedidoEntity = gerarPedidoEntity(StatusPedido.RECEBIDO);
        PedidoEntity pedidoEntityEmPreparacao = gerarPedidoEntity(StatusPedido.EM_PREPARACAO);

        when(pedidoRepository.findById(pedidoId)).thenReturn(Optional.of(pedidoEntity));
        when(pedidoRepository.save(pedidoEntity)).thenReturn(pedidoEntityEmPreparacao);

        var result = pedidoEmPreparacaoAdapter.execute(pedidoId);

        verify(pedidoRepository, times(1)).findById(anyLong());
        verify(pedidoRepository, times(1)).save(any());
        Assertions.assertEquals(pedidoEntityEmPreparacao.getEtapa(), result.getEtapa());
    }

    @Test
    public void deveLancarExcessaoQuandoPedidoNaoForEncontrado() {
        Long pedidoId = 1L;
        when(pedidoRepository.findById(pedidoId)).thenThrow(new NoSuchElementException("No value present"));

        Pedido result = null;
        try {
            result = pedidoEmPreparacaoAdapter.execute(pedidoId);
            Assertions.fail();
        } catch (Exception e) {
            verify(pedidoRepository, times(1)).findById(anyLong());
            verify(pedidoRepository, times(0)).save(any());
            Assertions.assertNull(result);
        }
    }
}