package com.example.demo.adapter.controller.response.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse {

    private String nome;
    private String cpf;
    private String email;
    @JsonProperty("id_cliente")
    private Long idCliente;
    @JsonProperty("data_cadastro")
    private String dataCadastro;

}
