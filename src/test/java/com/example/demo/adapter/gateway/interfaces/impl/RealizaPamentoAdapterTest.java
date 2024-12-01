package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.FormasPagamentoEnum;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.core.usecase.interfaces.pedido.BuscarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.SalvarPedidoUseCasePort;
import com.example.demo.infrastructure.integration.shogun.pagamento.ShogunPagamentoClient;
import com.example.demo.infrastructure.integration.shogun.pagamento.request.PagamentoRequest;
import com.example.demo.infrastructure.integration.shogun.pagamento.response.PagamentoResponse;
import static com.example.demo.mocks.PedidoHelper.gerarPagamentoResponse;
import static com.example.demo.mocks.PedidoHelper.gerarPedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

class RealizaPamentoAdapterTest {

    ShogunPagamentoClient shogunPagamentoClient = mock(ShogunPagamentoClient.class);
    BuscarPedidoUseCasePort buscarPedidoUseCasePort = mock(BuscarPedidoUseCasePort.class);
    SalvarPedidoUseCasePort salvarPedidoUseCasePort = mock(SalvarPedidoUseCasePort.class);
    RealizaPamentoAdapter realizaPamentoAdapter = new RealizaPamentoAdapter(shogunPagamentoClient, buscarPedidoUseCasePort, salvarPedidoUseCasePort);

    @Test
    public void deveRealizarPagamentoComSucesso() {
        Long pedidoId = 1L;
        Pedido pedido = gerarPedido(StatusPedido.RECEBIDO.name());
        Pedido pedidoEmPreparacao = gerarPedido(StatusPedido.EM_PREPARACAO.name());
        PagamentoResponse pagamentoResponse = gerarPagamentoResponse();
        ResponseEntity<PagamentoResponse> responseEntity = new ResponseEntity<>(pagamentoResponse, HttpStatus.CREATED);
        PagamentoRequest pagamentoRequest = PagamentoRequest.builder()
                .numeroPedido(pedidoId)
                .valorTotal(BigDecimal.valueOf(pedido.getValorTotal()))
                .tipoDoPagamento(FormasPagamentoEnum.QR_CODE_PAGBANK)
                .build();

        when(buscarPedidoUseCasePort.buscarPorId(pedidoId)).thenReturn(pedido);
        when(shogunPagamentoClient.realizarPagamento(pagamentoRequest)).thenReturn(responseEntity);
        when(salvarPedidoUseCasePort.execute(pedido)).thenReturn(pedidoEmPreparacao);

        var result = realizaPamentoAdapter.realizaPagamento(pagamentoRequest);

        verify(buscarPedidoUseCasePort, times(1)).buscarPorId(anyLong());
        verify(shogunPagamentoClient, times(1)).realizarPagamento(any());
        verify(salvarPedidoUseCasePort, times(1)).execute(any());
        Assertions.assertEquals(StatusPedido.EM_PREPARACAO.name(), result.getEtapa().toString());
    }
}