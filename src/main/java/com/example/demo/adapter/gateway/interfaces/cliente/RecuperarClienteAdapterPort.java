package com.example.demo.adapter.gateway.interfaces.cliente;

import com.example.demo.core.domain.Cliente;

public interface RecuperarClienteAdapterPort {
    Cliente execute(String documentoCliente);
    Cliente recuperarPorId(Long Id);
}
