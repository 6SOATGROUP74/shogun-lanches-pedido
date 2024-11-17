package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Produto;
import com.example.demo.infrastructure.repository.ProdutoRepository;
import com.example.demo.infrastructure.repository.entity.ProdutoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class GerenciarProdutoAdapterTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private GerenciarProdutoAdapter gerenciarProdutoAdapter;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvarProduto_NaoDeveRetornarException() {
        when(repository.save(any(ProdutoEntity.class)))
                .thenReturn(new ProdutoEntity());

        assertDoesNotThrow(() -> gerenciarProdutoAdapter.salvar(any(Produto.class)));
    }

    @Test
    void buscarProdutoPorCategoria_NaoDeveRetornarException() {
        String categoria = "Lanche";

        when(repository.findByCategoriaAndStatus(categoria, true))
                .thenReturn(List.of(new ProdutoEntity()));

        assertDoesNotThrow(() -> gerenciarProdutoAdapter.buscarProdutoPorCategoria(categoria));
    }

    @Test
    void buscarProdutoPorId_NaoDeveRetornarException() {
        when(repository.findById(anyLong()))
                .thenReturn(Optional.of(new ProdutoEntity()));

        assertDoesNotThrow(() -> gerenciarProdutoAdapter.buscarProdutoPorId(anyLong()));
    }

}