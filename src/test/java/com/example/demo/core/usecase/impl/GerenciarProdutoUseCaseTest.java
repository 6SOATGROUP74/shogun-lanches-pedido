package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.produto.GerenciarProdutoAdapterPort;
import com.example.demo.core.domain.Produto;
import com.example.demo.exceptions.CategoriaInvalidaException;
import com.example.demo.exceptions.ProdutoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class GerenciarProdutoUseCaseTest {

    @Mock
    private GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort;

    @InjectMocks
    GerenciarProdutoUseCase gerenciarProdutoUseCase;


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvar_deveLancarExceptionCategoriaInvalida(){
        Produto produto = new Produto();
        produto.setCategoria("INEXISTENTE");

       assertThrows(CategoriaInvalidaException.class, () ->
               gerenciarProdutoUseCase.salvar(produto));
    }

    @Test
    void salvar_deveRetornarUmProdutoValido(){
        Produto produto = new Produto();
        produto.setCategoria("LANCHE");

        when(gerenciarProdutoAdapterPort.salvar(eq(produto))).thenReturn(new Produto());

        assertNotNull(gerenciarProdutoUseCase.salvar(produto));

    }

    @Test
    void buscarProdutoPorCategoria_deveRetornarUmaListaDeProdutoValida(){
        Produto produto = new Produto();
        produto.setCategoria("LANCHE");

        when(gerenciarProdutoAdapterPort.buscarProdutoPorCategoria(eq(produto.getCategoria()))).thenReturn(List.of(new Produto()));

        assertNotNull(gerenciarProdutoUseCase.buscarProdutoPorCategoria(produto.getCategoria()));

    }

    @Test
    void buscarProdutoPorCategoria_deveLancarExceptionCategoriaInvalida(){
        Produto produto = new Produto();
        produto.setCategoria("INEXISTENTE");

        assertThrows(CategoriaInvalidaException.class, () -> gerenciarProdutoUseCase.buscarProdutoPorCategoria(produto.getCategoria()));

    }

    @Test
    void deletarProduto_deveLancarExceptionProdutoNotFoundException(){
        Produto produto = new Produto();
        when(gerenciarProdutoAdapterPort.buscarProdutoPorId(anyLong())).thenReturn(null);

        assertThrows(ProdutoNotFoundException.class, () ->
                gerenciarProdutoUseCase.deletarProduto(anyLong()));

    }


    @Test
    void deletarProduto_deveExecutarComSucesso(){
        Produto produto = new Produto();
        when(gerenciarProdutoAdapterPort.buscarProdutoPorId(anyLong())).thenReturn(new Produto());

        assertDoesNotThrow(() -> gerenciarProdutoUseCase.deletarProduto(anyLong()));

    }

    @Test
    void alterarProduto_deveLancarExceptionProdutoNotFoundException(){
        Produto produto = new Produto();
        produto.setIdProduto(2L);
        when(gerenciarProdutoAdapterPort.buscarProdutoPorId(eq(produto.getIdProduto()))).thenReturn(null);
        assertThrows(ProdutoNotFoundException.class, () -> gerenciarProdutoUseCase.alterarProduto(produto,produto.getIdProduto()));

    }

    @Test
    void alterarProduto_deveRetornarUmProdutoValido(){
        Produto produto = new Produto();
        produto.setIdProduto(20L);
        when(gerenciarProdutoAdapterPort.buscarProdutoPorId(eq(1L))).thenReturn(produto);
        when(gerenciarProdutoAdapterPort.salvar(eq(produto))).thenReturn(new Produto());

        assertNotNull(gerenciarProdutoUseCase.alterarProduto(produto, 1L));

    }


}