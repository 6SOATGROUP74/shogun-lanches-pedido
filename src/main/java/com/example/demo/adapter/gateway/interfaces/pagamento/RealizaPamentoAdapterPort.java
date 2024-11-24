package com.example.demo.adapter.gateway.interfaces.pagamento;

import com.example.demo.core.domain.Pedido;
import com.example.demo.infrastructure.integration.shogun.pagamento.request.PagamentoRequest;

public interface RealizaPamentoAdapterPort {
    Pedido realizaPagamento(PagamentoRequest pagamentoRequest);
}
