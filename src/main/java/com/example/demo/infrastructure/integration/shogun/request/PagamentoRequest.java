package com.example.demo.infrastructure.integration.shogun.request;

import com.example.demo.core.domain.FormasPagamentoEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class PagamentoRequest {

    @NotEmpty(message = "O campo não pode ser vazio.")
    @NotNull(message = "O campo obrigatório")
    @JsonProperty("numero_pedido")
    private Long numeroPedido;

    @JsonProperty("valor_total")
    private BigDecimal valorTotal;

    @NotEmpty(message = "O campo não pode ser vazio.")
    @NotNull(message = "O campo obrigatório")
    @JsonProperty("tipo_do_pagamento")
    private FormasPagamentoEnum tipoDoPagamento;
}
