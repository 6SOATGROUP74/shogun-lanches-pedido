package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Cliente;
import com.example.demo.infrastructure.repository.ClienteRepository;
import com.example.demo.infrastructure.repository.entity.ClienteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class IncluirClienteAdapterTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private IncluirClienteAdapter incluirClienteAdapter;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeCliente_NaoDeveRetornarException() {
        when(repository.save(any(ClienteEntity.class)))
                .thenReturn(new ClienteEntity());

        assertDoesNotThrow(() -> incluirClienteAdapter.execute(any(Cliente.class)));
    }

}