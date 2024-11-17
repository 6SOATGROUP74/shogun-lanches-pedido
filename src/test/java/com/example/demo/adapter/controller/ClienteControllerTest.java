package com.example.demo.adapter.controller;

import com.example.demo.adapter.controller.request.cliente.ClienteRequest;
import com.example.demo.adapter.controller.request.pedido.mapper.ClienteMapper;
import com.example.demo.adapter.controller.response.cliente.ClienteResponse;
import com.example.demo.adapter.presenter.cliente.ClienteResponseMapper;
import com.example.demo.core.domain.Cliente;
import com.example.demo.core.usecase.interfaces.cliente.IncluirClienteUseCasePort;
import com.example.demo.core.usecase.interfaces.cliente.RecuperarClienteUseCasePort;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClienteControllerTest {

    @Mock
    private IncluirClienteUseCasePort incluirClienteUseCasePort;

    @Mock
    private RecuperarClienteUseCasePort recuperarClienteUseCasePort;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void incluirCliente_DeveRetornarStatusCreated() {

        when(incluirClienteUseCasePort.execute(any(Cliente.class)))
                .thenReturn(new Cliente("Nome", 1L, "00000000000", "igor@igor.com"));

        ResponseEntity<?> responseEntity = clienteController.incluir(any(ClienteRequest.class));

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    void recuperarCliente_DeveRetornarStatusOK() {

        when(recuperarClienteUseCasePort.execute(any(String.class)))
                .thenReturn(new Cliente("Nome", 1L, "00000000000", "igor@igor.com"));

        ResponseEntity<?> responseEntity = clienteController.recuperar(any(String.class));

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}