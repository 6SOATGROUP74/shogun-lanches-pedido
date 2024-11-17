package com.example.demo.adapter.controller;

import com.example.demo.adapter.controller.request.produto.ProdutoRequest;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ProdutoControllerTest {

    @InjectMocks
    ProdutoController produtoController;

    @Mock
    GerenciarProdutoUseCasePort gerenciarProdutoUseCasePort;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void incluirProduto_DeveRetornarStatusCreated(){

        when(gerenciarProdutoUseCasePort.salvar(any(Produto.class)))
                .thenReturn(new Produto());

        ResponseEntity<?> responseEntity = produtoController.incluir(any(ProdutoRequest.class));

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }


    @Test
    void alterarProduto_DeveRetornarStatusOK(){

        when(gerenciarProdutoUseCasePort.alterarProduto(any(Produto.class), anyLong()))
                .thenReturn(new Produto());

        ResponseEntity<?> responseEntity = produtoController.alterar(any(ProdutoRequest.class), anyLong());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void deletarProduto_DeveRetornarStatusOK(){

        ResponseEntity<?> responseEntity = produtoController.deletar(anyLong());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }




}