package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.impl.AtualizarPedidoAdapter;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.core.usecase.interfaces.pedido.BuscarPedidoUseCasePort;
import static com.example.demo.mocks.PedidoHelper.gerarPedido;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AlterarPedidoUseCaseTest {

    AtualizarPedidoAdapter atualizarPedidoAdapter = mock(AtualizarPedidoAdapter.class);
    BuscarPedidoUseCasePort buscarPedidoUseCasePort = mock(BuscarPedidoUseCasePort.class);
    AlterarPedidoUseCase alterarPedidoUseCase = new AlterarPedidoUseCase(atualizarPedidoAdapter, buscarPedidoUseCasePort);

    @Test
    public void deveAlterarPedidoComSucesso(){
        Long pedidoId= 1L;
        Pedido pedido = gerarPedido(StatusPedido.EM_PREPARACAO.name());

        when(buscarPedidoUseCasePort.buscarPorId(pedidoId)).thenReturn(pedido);
        when(atualizarPedidoAdapter.execute(pedido)).thenReturn(pedido);

        alterarPedidoUseCase.execute(pedido);

        verify(buscarPedidoUseCasePort, times(1)).buscarPorId(anyLong());
        verify(atualizarPedidoAdapter, times(1)).execute(any());
    }

}