package com.example.demo.infrastructure.integration.shogun.pagamento;

import com.example.demo.infrastructure.integration.shogun.pagamento.response.PagamentoResponse;
import com.example.demo.infrastructure.integration.shogun.request.PagamentoRequest;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PagamentoResponse> realizarPagamento(@RequestBody PagamentoRequest pagamentoRequest);

    @GetMapping(value = "/{pagamentoId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PagamentoResponse> consultaStatusPagamento(@PathVariable Long pagamentoId);

    @PostMapping(value = "/confirma-pagamento/{pagamentoId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PagamentoResponse> confirmaPagamento(@PathVariable Long pagamentoId);
}