package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Produto;
import com.example.demo.infrastructure.integration.shogun.produto.ProdutoResponse;
import com.example.demo.infrastructure.integration.shogun.produto.ShogunProdutoClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class GerenciarProdutoAdapterTest {

    private ShogunProdutoClient shogunProdutoClient;
    private GerenciarProdutoAdapter gerenciarProdutoAdapter;

    @BeforeEach
    void setUp() {
        shogunProdutoClient = mock(ShogunProdutoClient.class);
        gerenciarProdutoAdapter = new GerenciarProdutoAdapter(shogunProdutoClient);
    }

    @Test
    void deveBuscarProdutoPorIdComSucesso() {
        ProdutoResponse mockResponse = new ProdutoResponse();

        when(shogunProdutoClient.buscaPorId(anyLong())).thenReturn(mockResponse);

        Produto resultado = gerenciarProdutoAdapter.buscarProdutoPorId(1L);

        assertThat(resultado).isNotNull();

        verify(shogunProdutoClient, times(1)).buscaPorId(anyLong());
    }
}
