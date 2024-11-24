package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.adapter.gateway.interfaces.pagamento.RealizaPamentoAdapterPort;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.core.usecase.interfaces.pedido.BuscarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.SalvarPedidoUseCasePort;
import com.example.demo.infrastructure.integration.shogun.pagamento.ShogunPagamentoClient;
import com.example.demo.infrastructure.integration.shogun.pagamento.request.PagamentoRequest;

import com.example.demo.infrastructure.integration.shogun.pagamento.response.PagamentoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RealizaPamentoAdapter implements RealizaPamentoAdapterPort {

    private Logger logger = LoggerFactory.getLogger(RealizaPamentoAdapter.class);

    private final ShogunPagamentoClient shogunPagamentoClient;
    private final BuscarPedidoUseCasePort buscarPedidoUseCasePort;
    private final SalvarPedidoUseCasePort salvarPedidoUseCasePort;

    public RealizaPamentoAdapter(ShogunPagamentoClient shogunPagamentoClient, BuscarPedidoUseCasePort buscarPedidoUseCasePort, SalvarPedidoUseCasePort salvarPedidoUseCasePort) {
        this.shogunPagamentoClient = shogunPagamentoClient;
        this.buscarPedidoUseCasePort = buscarPedidoUseCasePort;
        this.salvarPedidoUseCasePort = salvarPedidoUseCasePort;
    }

    @Override
    public Pedido realizaPagamento(PagamentoRequest pagamentoRequest) {
        Pedido pedidoAtual = buscarPedidoUseCasePort.buscarPorId(pagamentoRequest.getNumeroPedido());

        PagamentoResponse pagamentoResponse = shogunPagamentoClient.realizarPagamento(pagamentoRequest).getBody();

        pedidoAtual.setCodPedido(pagamentoResponse.getCodPagamento());
        pedidoAtual.setIdPagamento(pagamentoResponse.getIdPagamento());
        pedidoAtual.setEtapa(StatusPedido.EM_PREPARACAO.name());
        pedidoAtual.setDataMudancaEtapa(LocalDateTime.now().toString());

        salvarPedidoUseCasePort.execute(pedidoAtual);

        return pedidoAtual;
    }
}
