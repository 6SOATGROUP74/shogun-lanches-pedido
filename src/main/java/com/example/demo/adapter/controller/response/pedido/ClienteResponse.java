package com.example.demo.adapter.controller.response.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse {

    private String nome;
    private String cpf;

    @JsonProperty("id_cliente")
    private String idCliente;

}
