package com.example.demo.infrastructure.integration.shogun.producao;

import com.example.demo.adapter.controller.request.common.ProducaoRequest;
import com.example.demo.core.domain.StatusPedido;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings
class EnviaPedidoParaProducaoAdapterTest {

    @Mock
    SqsTemplate sqsTemplate = mock(SqsTemplate.class);

    @InjectMocks
    EnviaPedidoParaProducaoAdapter enviaPedidoParaProducaoAdapter = new EnviaPedidoParaProducaoAdapter();

    @Test
    public void deveEnviarPedidoComSucesso() {
        ProducaoRequest producaoRequest = new ProducaoRequest();
        producaoRequest.setNumeroPedido(1L);
        producaoRequest.setIdPagamento(1L);
        producaoRequest.setStatusPedido(StatusPedido.EM_PREPARACAO.name());

       when(sqsTemplate.send(any())).thenReturn(any());

        enviaPedidoParaProducaoAdapter.enviaPedido(producaoRequest);

        verify(sqsTemplate, times(1)).send(any());
    }
}