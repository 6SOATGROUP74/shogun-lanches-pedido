package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.cliente.IncluirClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.core.domain.Cliente;
import com.example.demo.exceptions.ClienteDuplicadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class IncluirClienteUseCaseTest {

    @Mock
    private IncluirClienteAdapterPort incluirClienteAdapterPort;

    @Mock
    private RecuperarClienteAdapterPort recuperarClienteAdapterPort;


    @InjectMocks
    private IncluirClienteUseCase incluirClienteUseCase;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_DeveLancarExceptionClienteDuplicadoException(){
        Cliente cliente = new Cliente();
        cliente.setCpf("00000000");

        when(recuperarClienteAdapterPort.execute(eq(cliente.getCpf()))).thenReturn(new Cliente());

        assertThrows(ClienteDuplicadoException.class, () -> incluirClienteUseCase.execute(cliente));


    }

    @Test
    void execute_DeveRetornarUmClienteValido() {

        Cliente cliente = new Cliente();
        cliente.setCpf("00000000");

        when(recuperarClienteAdapterPort.execute(eq(cliente.getCpf()))).thenReturn(null);


        when(incluirClienteAdapterPort.execute(eq(cliente))).thenReturn(new Cliente());

        assertNotNull(incluirClienteUseCase.execute(cliente));

    }



}