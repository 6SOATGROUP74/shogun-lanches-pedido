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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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
    public void deveGerarPedidoComSucesso(){
        Cliente cliente = new Cliente("José da Silva", 1L, "111111111", "jose@gmail.com");
        Pedido pedido = gerarPedido(null);
        Pedido pedidoRecebido = gerarPedido(StatusPedido.RECEBIDO.name());
        Produto produto1 = pedido.getComposicao().get(0).getProduto();
        Produto produto2 = pedido.getComposicao().get(1).getProduto();
        Produto produto3 = pedido.getComposicao().get(2).getProduto();
        Produto produto4 = pedido.getComposicao().get(3).getProduto();

        when(gerenciarProdutoAdapter.buscarProdutoPorId(1L)).thenReturn(produto1);
        when(gerenciarProdutoAdapter.buscarProdutoPorId(2L)).thenReturn(produto2);
        when(gerenciarProdutoAdapter.buscarProdutoPorId(3L)).thenReturn(produto3);
        when(gerenciarProdutoAdapter.buscarProdutoPorId(4L)).thenReturn(produto4);
        when(recuperarClienteAdapterPort.recuperarPorId(cliente.getIdCliente())).thenReturn(cliente);
        when(salvarPedidoAdapterPort.execute(pedido)).thenReturn(pedidoRecebido);
        when(buscarPedidoAdapterPort.execute(pedidoRecebido.getNumeroPedido())).thenReturn(pedidoRecebido);

        var result = criarPedidoUseCase.criarPedido(pedido);

        verify(gerenciarProdutoAdapter, times(4)).buscarProdutoPorId(anyLong());
        verify(recuperarClienteAdapterPort, times(1)).recuperarPorId(anyLong());
        verify(salvarPedidoAdapterPort, times(1)).execute(any());
        verify(buscarPedidoAdapterPort, times(1)).execute(anyLong());
        Assertions.assertEquals(pedidoRecebido.getEtapa(), result.getEtapa());
    }

}