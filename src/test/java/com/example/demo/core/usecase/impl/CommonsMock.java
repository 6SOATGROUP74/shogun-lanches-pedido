package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Cliente;
import com.example.demo.core.domain.Composicao;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.Produto;

import java.util.ArrayList;
import java.util.List;

public class CommonsMock {


    public static Cliente buildCliente(){
        var cliente = new Cliente();

        cliente.setIdCliente(1L);
        cliente.setDataCadastro("2024-01-01");
        cliente.setCpf("00000000");
        cliente.setNome("Igu");
        cliente.setEmail("email@email.com");

        return cliente;
    }

    public static Produto buildProduto(){
        var produto = new Produto();
        produto.setIdProduto(1L);
        produto.setStatus(true);
        produto.setCategoria("Lanche");
        produto.setValor(10.1);
        produto.setQuantidade(1L);
        produto.setNome("X-TUDAO");

        return produto;
    }

    public static Pedido buildPedido(){
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
