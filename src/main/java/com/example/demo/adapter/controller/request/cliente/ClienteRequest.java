package com.example.demo.adapter.controller.request.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class ClienteRequest {

    @Size(max = 255, message = "O campo nome possui um tamanho máximo de 255 caracteres.")
    @NotEmpty(message = "O campo não pode ser vazio.")
    private String nome;

    @CPF(message = "CPF invalido.")
    @NotEmpty(message = "O campo não pode ser vazio.")
    private String cpf;

    @Email(message = "Email invalido.")
    @NotEmpty(message = "O campo não pode ser vazio.")
    private String email;

}
