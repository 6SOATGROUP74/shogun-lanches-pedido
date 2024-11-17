package com.example.demo.adapter.controller.request.pedido;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequest {

    @NotEmpty(message = "O campo não pode ser vazio.")
    @NotNull(message = "O campo obrigatório")
    private String nome;

    @NotEmpty(message = "O campo não pode ser vazio.")
    @NotNull(message = "O campo obrigatório")
    private String cpf;

}
