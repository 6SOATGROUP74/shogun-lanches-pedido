package com.example.demo.adapter.controller.request.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PedidoRequest {

    @JsonProperty("id_cliente")
    private Long idCliente;

    @NotNull(message = "O campo obrigatório")
    private List<ComposicaoRequest> composicao;
}
