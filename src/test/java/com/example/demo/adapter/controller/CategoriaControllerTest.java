package com.example.demo.adapter.controller;

import com.example.demo.adapter.controller.request.cliente.ClienteRequest;
import com.example.demo.core.domain.Produto;
import com.example.demo.core.usecase.interfaces.produto.GerenciarProdutoUseCasePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CategoriaControllerTest {

    @Mock
    private GerenciarProdutoUseCasePort gerenciarProdutoUseCasePort;

    @InjectMocks
    private CategoriaController categoriaController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscar_DeveRetornarStatusOk() {

        when(gerenciarProdutoUseCasePort.buscarProdutoPorCategoria(anyString()))
                .thenReturn(List.of(new Produto()));

        ResponseEntity<?> responseEntity = categoriaController.buscar(anyString());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }


}