package com.example.demo.infrastructure.integration.shogun.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ClienteResponse {

    @JsonProperty("id_cliente")
    private String idCliente;

}