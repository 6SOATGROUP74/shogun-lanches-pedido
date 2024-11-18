package com.example.demo.adapter.controller;

import com.example.demo.infrastructure.integration.shogun.pagamento.ShogunPagamentoClient;
import com.example.demo.infrastructure.integration.shogun.pagamento.response.PagamentoResponse;
import com.example.demo.infrastructure.integration.shogun.request.PagamentoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pedido")
public class PagamentoController {

    private static final Logger logger = LoggerFactory.getLogger(PagamentoController.class);

    private final ShogunPagamentoClient shogunPagamentoClient;

    public PagamentoController(ShogunPagamentoClient shogunPagamentoClient, ShogunPagamentoClient shogunPagamentoClient1) {
        this.shogunPagamentoClient = shogunPagamentoClient1;
    }

    @PostMapping
    public ResponseEntity<?> realizarPagamento(@RequestBody PagamentoRequest pagamentoRequest) {

        logger.info("m=realizarPagamento, status=init,  msg=Realiza processo de pagamento, pagamentoRequest={}", pagamentoRequest);

        PagamentoResponse pagamentoResponse = shogunPagamentoClient.realizarPagamento(pagamentoRequest).getBody();

        logger.info("m=realizarPagamento, status=success,  msg=Processo de pagamento realizado com sucesso, pagamentoRequest={}", pagamentoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoResponse);
    }

    @GetMapping("/{pagamentoId}")
    public ResponseEntity<?> consultaStatusPagamento(@PathVariable Long pagamentoId) {

        logger.info("m=consultaStatusPagamento, status=init,  msg=Consulta status de pagamento, pagamentoId={}", pagamentoId);

        PagamentoResponse pagamentoResponse = shogunPagamentoClient.consultaStatusPagamento(pagamentoId).getBody();

        logger.info("m=consultaStatusPagamento, status=sucess,  msg=Consulta status de pagamento realizada com sucesso, pagamentoId={}", pagamentoId);

        return ResponseEntity.ok().body(pagamentoResponse);
    }

    @PostMapping("/confirma-pagamento/{pagamentoId}")
    public ResponseEntity<?> confirmaPagamento(@PathVariable Long pagamentoId) {

        logger.info("m=recebeConfirmacaoDePagamentoWebhook, msg=Recebendo confirmação de status de pagamento do Pagbank, pagamentoId={}", pagamentoId);

        PagamentoResponse pagamentoResponse = shogunPagamentoClient.confirmaPagamento(pagamentoId).getBody();

        logger.info("m=recebeConfirmacaoDePagamentoWebhook, msg=Confirmação de pagamento recebido do Pagbank com sucesso, pagamentoId={}", pagamentoId);

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoResponse);
    }
}
