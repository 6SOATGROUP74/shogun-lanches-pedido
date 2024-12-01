package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.core.usecase.interfaces.pedido.BuscarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.SalvarPedidoUseCasePort;
import static com.example.demo.mocks.PedidoHelper.gerarPedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ConclusaoPedidoUserCaseTest {

    SalvarPedidoUseCasePort salvarPedidoUseCasePort = mock(SalvarPedidoUseCasePort.class);
    BuscarPedidoUseCasePort buscarPedidoUseCasePort = mock(BuscarPedidoUseCasePort.class);
    ConclusaoPedidoUserCase conclusaoPedidoUserCase = new ConclusaoPedidoUserCase(salvarPedidoUseCasePort, buscarPedidoUseCasePort);

    @Test
    public void deveConcluirPedidoComSucesso(){
        Long pedidoId = 1L;
        Pedido pedido = gerarPedido(StatusPedido.PRONTO.name());
        Pedido pedidoFinalizado = gerarPedido(StatusPedido.FINALIZADO.name());

        when(buscarPedidoUseCasePort.buscarPorId(pedidoId)).thenReturn(pedido);
        when(salvarPedidoUseCasePort.execute(pedido)).thenReturn(pedido).thenReturn(pedidoFinalizado);

        var result = conclusaoPedidoUserCase.execute(pedido);

        verify(buscarPedidoUseCasePort, times(1)).buscarPorId(anyLong());
        verify(salvarPedidoUseCasePort, times(2)).execute(any());
        Assertions.assertEquals(pedidoFinalizado.getEtapa(), result.getEtapa());
    }
}