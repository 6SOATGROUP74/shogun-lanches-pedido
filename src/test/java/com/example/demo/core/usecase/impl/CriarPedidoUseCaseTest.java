package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.impl.GerenciarProdutoAdapter;
import com.example.demo.adapter.gateway.interfaces.pedido.BuscarPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.SalvarPedidoAdapterPort;
import com.example.demo.core.domain.Cliente;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.Produto;
import com.example.demo.core.domain.StatusPedido;
import static com.example.demo.mocks.PedidoHelper.gerarPedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.example.demo.mocks.PedidoHelper.gerarProduto;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CriarPedidoUseCaseTest {

    SalvarPedidoAdapterPort salvarPedidoAdapterPort = mock(SalvarPedidoAdapterPort.class);
    GerenciarProdutoAdapter gerenciarProdutoAdapter = mock(GerenciarProdutoAdapter.class);
    RecuperarClienteAdapterPort recuperarClienteAdapterPort = mock(RecuperarClienteAdapterPort.class);
    BuscarPedidoAdapterPort buscarPedidoAdapterPort = mock(BuscarPedidoAdapterPort.class);
    CriarPedidoUseCase criarPedidoUseCase = new CriarPedidoUseCase(salvarPedidoAdapterPort, gerenciarProdutoAdapter, recuperarClienteAdapterPort, buscarPedidoAdapterPort);

    @Test
    void deveGerarPedidoComSucesso(){
        Cliente cliente = new Cliente();
        cliente.setEmail("igor@igor.com");
        cliente.setCpf("48265391864");
        cliente.setIdCliente(UUID.randomUUID().toString());
        cliente.setNome("igu");


        Pedido pedido = gerarPedido(null);
        pedido.setIdCliente(UUID.randomUUID().toString());
        Pedido pedidoRecebido = gerarPedido(StatusPedido.RECEBIDO.name());

        when(gerenciarProdutoAdapter.buscarProdutoPorId(anyLong())).thenReturn(gerarProduto());
        when(recuperarClienteAdapterPort.recuperarPorId(anyString())).thenReturn(cliente);
        when(salvarPedidoAdapterPort.execute(pedido)).thenReturn(pedidoRecebido);
        when(buscarPedidoAdapterPort.execute(pedidoRecebido.getNumeroPedido())).thenReturn(pedidoRecebido);

        var result = criarPedidoUseCase.criarPedido(pedido);

        verify(gerenciarProdutoAdapter, times(4)).buscarProdutoPorId(anyLong());
        verify(recuperarClienteAdapterPort, times(1)).recuperarPorId(any());
        verify(salvarPedidoAdapterPort, times(1)).execute(any());
        verify(buscarPedidoAdapterPort, times(1)).execute(anyLong());
        Assertions.assertEquals(pedidoRecebido.getEtapa(), result.getEtapa());
    }

}