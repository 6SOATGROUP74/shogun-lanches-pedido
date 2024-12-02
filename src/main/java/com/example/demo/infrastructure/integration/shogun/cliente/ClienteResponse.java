package com.example.demo.infrastructure.integration.shogun.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ClienteResponse {

    private String nome;

    private String cpf;

    private String email;

    @JsonProperty("id_cliente")
    private String idCliente;

    @JsonProperty("data_cadastro")
    private String dataCadastro;

}