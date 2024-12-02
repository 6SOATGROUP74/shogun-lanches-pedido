package com.example.demo.infrastructure.integration.shogun.pagamento;

import com.example.demo.infrastructure.integration.shogun.pagamento.request.PagamentoRequest;
import com.example.demo.infrastructure.integration.shogun.pagamento.response.PagamentoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "ShogunPagamentoClient", url = "${shogun.lanches.pagamento.url}")
public interface ShogunPagamentoClient {

    @PostMapping(value = "/v1/pagamento", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PagamentoResponse> realizarPagamento(@RequestBody PagamentoRequest pagamentoRequest);

    @GetMapping(value = "/v1/pagamento/{pagamentoId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PagamentoResponse> consultaStatusPagamento(@PathVariable Long pagamentoId);

    @PostMapping(value = "/v1/pagamento/confirma-pagamento/{pagamentoId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PagamentoResponse> confirmaPagamento(@PathVariable Long pagamentoId);
}
