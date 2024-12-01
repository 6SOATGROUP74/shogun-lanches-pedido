package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.StatusPedido;
import com.example.demo.infrastructure.repository.PedidoRepository;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import static com.example.demo.mocks.PedidoHelper.gerarPedidoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

class ListarPedidoAdapterTest {

    PedidoRepository pedidoRepository = mock(PedidoRepository.class);
    ListarPedidoAdapter listarPedidoAdapter = new ListarPedidoAdapter(pedidoRepository);

    @Test
    public void deveListarTodosPedidosComSucesso(){
        List<PedidoEntity> pedidoEntityList = Arrays.asList(gerarPedidoEntity(StatusPedido.EM_PREPARACAO));

        when(pedidoRepository.findAll()).thenReturn(pedidoEntityList);

        listarPedidoAdapter.listarTodosPedidos();

        verify(pedidoRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void deveListarTodosPedidosOrdenadosComSucesso(){
        List<PedidoEntity> pedidoEntityList = Arrays.asList(gerarPedidoEntity(StatusPedido.EM_PREPARACAO));

        when(pedidoRepository.ordenaPedidos()).thenReturn(pedidoEntityList);

        listarPedidoAdapter.listarPedidosOrdenados();

        verify(pedidoRepository, Mockito.times(1)).ordenaPedidos();
    }

    @Test
    public void devebuscarPedidoPorCodReferenciaComSucesso(){
        String codReferencia = "ORDER_123";
        PedidoEntity pedidoEntity = gerarPedidoEntity(StatusPedido.EM_PREPARACAO);

        when(pedidoRepository.findByCodReferenciaPedido(codReferencia)).thenReturn(pedidoEntity);

        var result =listarPedidoAdapter.buscarPedidoPorCodReferencia(codReferencia);

        verify(pedidoRepository, Mockito.times(1)).findByCodReferenciaPedido(anyString());
        Assertions.assertEquals(pedidoEntity.getNumeroPedido(), result.getNumeroPedido());
    }
}