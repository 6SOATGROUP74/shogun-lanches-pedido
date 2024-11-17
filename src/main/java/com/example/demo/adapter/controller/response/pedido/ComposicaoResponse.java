package com.example.demo.adapter.controller.response.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComposicaoResponse {

    @JsonProperty("id_produto")
    private Long idProduto;

    @JsonProperty("id_composicao")
    private Long idComposicao;

    private int quantidade;

    @JsonProperty("nome_produto")
    private String nomeProduto;

    private String categoria;

    @JsonProperty("preco_unitario")
    private double precoUnitario;
}
