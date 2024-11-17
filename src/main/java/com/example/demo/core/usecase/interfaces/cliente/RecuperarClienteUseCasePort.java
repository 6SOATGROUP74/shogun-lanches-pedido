package com.example.demo.core.usecase.interfaces.cliente;

import com.example.demo.core.domain.Cliente;

public interface RecuperarClienteUseCasePort {
    Cliente execute(String documentoCliente);
}
