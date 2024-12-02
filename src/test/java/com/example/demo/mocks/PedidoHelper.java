package com.example.demo.mocks;

import com.example.demo.adapter.controller.request.pedido.ComposicaoRequest;
import com.example.demo.adapter.controller.request.pedido.PedidoRequest;
import com.example.demo.core.domain.Cliente;
import com.example.demo.core.domain.Composicao;
import com.example.demo.core.domain.FormasPagamentoEnum;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.Produto;
import com.example.demo.core.domain.StatusPagamento;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.infrastructure.integration.shogun.pagamento.response.PagamentoResponse;
import com.example.demo.infrastructure.repository.entity.ComposicaoEntity;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class PedidoHelper {

    public static Pedido gerarPedido(String etapa) {
        Cliente cliente = new Cliente("Jack Daniels", UUID.randomUUID().toString(), "1111111111", "jackdaniels@gmail.com", "2024-01-01");

        Produto produto1 = new Produto();
        produto1.setNome("Hamburguer da casa");
        produto1.setQuantidade(1L);
        produto1.setCategoria("Lanche");
        produto1.setValor(17.60);
        produto1.setIdProduto(1L);
        produto1.setStatus(true);

        Produto produto2 = new Produto();
        produto2.setNome("Batata clássica");
        produto2.setQuantidade(1L);
        produto2.setCategoria("Acompanhamento");
        produto2.setValor(9.00);
        produto2.setIdProduto(2L);
        produto2.setStatus(true);

        Produto produto3 = new Produto();
        produto3.setNome("Coca-cola");
        produto3.setQuantidade(1L);
        produto3.setCategoria("Bebida");
        produto3.setValor(5.00);
        produto3.setIdProduto(3L);
        produto3.setStatus(true);

        Produto produto4 = new Produto();
        produto4.setNome("Casquinha");
        produto4.setQuantidade(1L);
        produto4.setCategoria("Sobremesa");
        produto4.setValor(3.00);
        produto4.setIdProduto(4L);
        produto4.setStatus(true);

        Composicao composicao1 = new Composicao();
        composicao1.setIdComposicao(1L);
        composicao1.setIdProduto(produto1.getIdProduto());
        composicao1.setNomeProduto(produto1.getNome());
        composicao1.setQuantidade(produto1.getQuantidade().intValue());
        composicao1.setPrecoUnitario(produto1.getValor());

        Composicao composicao2 = new Composicao();
        composicao2.setIdComposicao(2L);
        composicao2.setIdProduto(produto2.getIdProduto());
        composicao2.setNomeProduto(produto2.getNome());
        composicao2.setQuantidade(produto2.getQuantidade().intValue());
        composicao2.setPrecoUnitario(produto2.getValor());

        Composicao composicao3 = new Composicao();
        composicao3.setIdComposicao(3L);
        composicao3.setIdProduto(produto3.getIdProduto());
        composicao3.setNomeProduto(produto3.getNome());
        composicao3.setQuantidade(produto3.getQuantidade().intValue());
        composicao3.setPrecoUnitario(produto3.getValor());

        Composicao composicao4 = new Composicao();
        composicao4.setIdComposicao(4L);
        composicao4.setIdProduto(produto4.getIdProduto());
        composicao4.setNomeProduto(produto4.getNome());
        composicao4.setQuantidade(produto4.getQuantidade().intValue());
        composicao4.setPrecoUnitario(produto4.getValor());

        Pedido pedido = new Pedido();
        pedido.setNumeroPedido(1L);
        pedido.setComposicao(Arrays.asList(composicao1, composicao2, composicao3, composicao4));
        pedido.setEtapa(etapa);
        pedido.setIdPagamento(1L);
        pedido.setDataPedido(LocalDateTime.now().toString());
        pedido.setCodPedido("011a5003-e10c-4ec5-9430-5d021704350b");
        pedido.setCodReferenciaPedido("ORDER_1234");
        pedido.setDataMudancaEtapa(LocalDateTime.now().plusMinutes(15).toString());
        pedido.setValorTotal(34.60);

        return pedido;
    }

    public static Produto gerarProduto(){
        Produto produto4 = new Produto();
        produto4.setNome("Casquinha");
        produto4.setQuantidade(1L);
        produto4.setCategoria("Sobremesa");
        produto4.setValor(3.00);
        produto4.setIdProduto(4L);
        produto4.setStatus(true);

        return produto4;
    }

    public static PagamentoResponse gerarPagamentoResponse() {
        PagamentoResponse pagamentoResponse = new PagamentoResponse();
        pagamentoResponse.setStatusDoPagamento(StatusPagamento.APROVADO.name());
        pagamentoResponse.setValorTotal(BigDecimal.valueOf(3460));
        pagamentoResponse.setTipoDoPagamento(FormasPagamentoEnum.QR_CODE_PAGBANK.name());
        pagamentoResponse.setDataPagamento(LocalDateTime.now().toString());
        pagamentoResponse.setCodPagamento("TESTE");
        pagamentoResponse.setIdPagamento(1L);
        pagamentoResponse.setCopiaCola("testeQrCode");
        pagamentoResponse.setQrCodeLink("linkQrCode");

        return pagamentoResponse;
    }

    public static PedidoRequest gerarPedidoRequest() {
        Long idCliente = 1L;
        ComposicaoRequest composicaoRequest = new ComposicaoRequest();
        composicaoRequest.setIdProduto(1L);
        composicaoRequest.setQuantidade(10);
        PedidoRequest pedidoRequest = new PedidoRequest();
        pedidoRequest.setIdCliente(UUID.randomUUID().toString());
        pedidoRequest.setComposicao(Arrays.asList(composicaoRequest));

        return pedidoRequest;
    }


    public static PedidoEntity gerarPedidoEntity(StatusPedido statusPedido){


        ComposicaoEntity composicaoEntity1 = new ComposicaoEntity();
        composicaoEntity1.setIdComposicao(1L);
        composicaoEntity1.setQuantidade(1);
        composicaoEntity1.setPrecoUnitario(BigDecimal.TEN.doubleValue());

        ComposicaoEntity composicaoEntity2 = new ComposicaoEntity();
        composicaoEntity2.setIdComposicao(2L);
        composicaoEntity2.setQuantidade(1);
        composicaoEntity2.setPrecoUnitario(BigDecimal.TEN.doubleValue());

        ComposicaoEntity composicaoEntity3 = new ComposicaoEntity();
        composicaoEntity3.setIdComposicao(3L);
        composicaoEntity2.setQuantidade(1);
        composicaoEntity3.setPrecoUnitario(BigDecimal.TEN.doubleValue());

        ComposicaoEntity composicaoEntity4 = new ComposicaoEntity();
        composicaoEntity4.setIdComposicao(4L);
        composicaoEntity2.setQuantidade(1);
        composicaoEntity4.setPrecoUnitario(BigDecimal.TEN.doubleValue());

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setNumeroPedido(1L);
        pedidoEntity.setComposicao(Arrays.asList(composicaoEntity1, composicaoEntity2, composicaoEntity3, composicaoEntity4));
        pedidoEntity.setEtapa(StatusPedido.EM_PREPARACAO.name());
        pedidoEntity.setIdPagamento(1L);
        pedidoEntity.setDataPedido(LocalDateTime.now().toString());
        pedidoEntity.setCodPedido("011a5003-e10c-4ec5-9430-5d021704350b");
        pedidoEntity.setCodReferenciaPedido("ORDER_1234");
        pedidoEntity.setDataMudancaEtapa(LocalDateTime.now().plusMinutes(15).toString());

        composicaoEntity1.setPedido(pedidoEntity);
        composicaoEntity2.setPedido(pedidoEntity);
        composicaoEntity3.setPedido(pedidoEntity);
        composicaoEntity4.setPedido(pedidoEntity);

        return pedidoEntity;
    }
}
