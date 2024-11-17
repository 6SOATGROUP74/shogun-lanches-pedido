package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.BuscarPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.SalvarPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.produto.GerenciarProdutoAdapterPort;
import com.example.demo.core.domain.Cliente;
import com.example.demo.core.domain.Composicao;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.Produto;
import com.example.demo.exceptions.ProdutoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class CriarPedidoUseCaseTest {

    @Mock
    SalvarPedidoAdapterPort salvarPedidoAdapterPort;

    @Mock
    GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort;

    @Mock
    RecuperarClienteAdapterPort recuperarClienteAdapterPort;

    @Mock
    BuscarPedidoAdapterPort buscarPedidoAdapterPort;

    @InjectMocks
    CriarPedidoUseCase criarPedidoUseCase;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void criarPedido_DeveRetornarUmNovoPedido(){

        var pedido = buildPedido();

        pedido.getComposicao().forEach(item -> {
            when(gerenciarProdutoAdapterPort.buscarProdutoPorId(eq(item.getIdProduto()))).thenReturn(buildProduto());
        });

        when(recuperarClienteAdapterPort.recuperarPorId(anyLong())).thenReturn(buildCliente());
        when(salvarPedidoAdapterPort.execute(any(Pedido.class))).thenReturn(buildPedido());
        when(buscarPedidoAdapterPort.execute(anyLong())).thenReturn(buildPedido());

        assertNotNull(criarPedidoUseCase.criarPedido(buildPedido()));

    }

    @Test
    void criarPedido_DeveLancarExceptionProdutoNotFoundException(){

        var pedido = buildPedido();
        pedido.getComposicao().add(new Composicao());

        when(gerenciarProdutoAdapterPort.buscarProdutoPorId(anyLong())).thenReturn(null);

        assertThrows(ProdutoNotFoundException.class, () -> {
            criarPedidoUseCase.criarPedido(pedido);
        } );

    }

    Cliente buildCliente(){
        var cliente = new Cliente();

        cliente.setIdCliente(1L);
        cliente.setDataCadastro("2024-01-01");
        cliente.setCpf("00000000");
        cliente.setNome("Igu");
        cliente.setEmail("email@email.com");

        return cliente;
    }

    Produto buildProduto(){
        var produto = new Produto();
        produto.setIdProduto(1L);
        produto.setStatus(true);
        produto.setCategoria("Lanche");
        produto.setValor(10.1);
        produto.setQuantidade(1L);
        produto.setNome("X-TUDAO");

        return produto;
    }

    Pedido buildPedido(){
        Cliente cliente = new Cliente();
        cliente.setNome("John Doe");
        cliente.setEmail("johndoe@example.com");
        cliente.setCpf("12345678900");

        List<Composicao> composicoes = new ArrayList<>();
        var composicao = new Composicao();
        composicao.setIdProduto(1L);
        composicoes.add(composicao);


        Pedido pedido = new Pedido();
        pedido.setNumeroPedido(12345L);
        pedido.setCliente(cliente);
        pedido.setValorTotal(200.0);
        pedido.setComposicao(composicoes);
        pedido.setEtapa("");
        pedido.setIdPagamento(98765L);
        pedido.setDataPedido("2024-09-21");
        pedido.setCodPedido("ABC123");
        pedido.setCodReferenciaPedido("REF123");
        pedido.setDataMudancaEtapa("2024-09-22");

        return pedido;
    }

}