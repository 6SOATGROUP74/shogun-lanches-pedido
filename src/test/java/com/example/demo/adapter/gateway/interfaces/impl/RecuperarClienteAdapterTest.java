package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Cliente;
import com.example.demo.infrastructure.integration.shogun.cliente.ClienteResponse;
import com.example.demo.infrastructure.integration.shogun.cliente.ShogunClienteClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class RecuperarClienteAdapterTest {

    private ShogunClienteClient shogunClienteClient;
    private RecuperarClienteAdapter recuperarClienteAdapter;

    @BeforeEach
    void setUp() {
        shogunClienteClient = mock(ShogunClienteClient.class);
        recuperarClienteAdapter = new RecuperarClienteAdapter(shogunClienteClient);
    }

    @Test
    void deveRecuperarClientePorIdComSucesso() {
        when(shogunClienteClient.buscaPorId(anyString())).thenReturn(new ClienteResponse());

        Cliente resultado = recuperarClienteAdapter.recuperarPorId(UUID.randomUUID().toString());

        assertThat(resultado).isNotNull();
        verify(shogunClienteClient, times(1)).buscaPorId(anyString());
    }
}
