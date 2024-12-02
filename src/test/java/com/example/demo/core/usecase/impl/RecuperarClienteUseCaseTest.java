package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.core.domain.Cliente;
import com.example.demo.exceptions.ClienteNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class RecuperarClienteUseCaseTest {

    private RecuperarClienteAdapterPort recuperarClienteAdapterPort;
    private RecuperarClienteUseCase recuperarClienteUseCase;

    @BeforeEach
    void setUp() {
        recuperarClienteAdapterPort = mock(RecuperarClienteAdapterPort.class);
        recuperarClienteUseCase = new RecuperarClienteUseCase(recuperarClienteAdapterPort);
    }

    @Test
    void deveRecuperarClientePorIdComSucesso() throws ClienteNotFoundException {
        String clienteId = UUID.randomUUID().toString();

        Cliente mockCliente = new Cliente();
        mockCliente.setIdCliente(clienteId);

        when(recuperarClienteAdapterPort.recuperarPorId(anyString())).thenReturn(mockCliente);

        Cliente resultado = recuperarClienteUseCase.recuperarPorId(clienteId);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado.getIdCliente()).isEqualTo(clienteId);

        verify(recuperarClienteAdapterPort, times(1)).recuperarPorId(clienteId);
    }

    @Test
    void deveLancarClienteNotFoundExceptionQuandoClienteNaoEncontrado() {
        String clienteId = UUID.randomUUID().toString();
        when(recuperarClienteAdapterPort.recuperarPorId(anyString()))
                .thenThrow(new ClienteNotFoundException("Cliente não encontrado"));

        assertThatThrownBy(() -> recuperarClienteUseCase.recuperarPorId(clienteId))
                .isInstanceOf(ClienteNotFoundException.class)
                .hasMessage("Cliente não encontrado");

        verify(recuperarClienteAdapterPort, times(1)).recuperarPorId(clienteId);
    }
}
