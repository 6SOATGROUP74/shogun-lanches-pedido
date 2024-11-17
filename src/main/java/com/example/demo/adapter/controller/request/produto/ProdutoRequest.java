package com.example.demo.adapter.controller.request.produto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequest {

    @NotEmpty(message = "Campo não pode ser vazio.")
    @Size(max = 255, message = "O campo nome possui um tamanho máximo de 255 caracteres.")
    private String nome;

    @NotEmpty(message = "Campo não pode ser vazio.")
    private String categoria;

    @NotNull(message = "Campo obrigatório")
    private Double valor;
}
