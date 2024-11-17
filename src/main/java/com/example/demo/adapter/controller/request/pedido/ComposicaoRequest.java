package com.example.demo.adapter.controller.request.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ComposicaoRequest {

    @NotNull(message = "O campo obrigatório")
    @JsonProperty("id_produto")
    private Long idProduto;

    @NotNull(message = "O campo obrigatório")
    private int quantidade;

}
