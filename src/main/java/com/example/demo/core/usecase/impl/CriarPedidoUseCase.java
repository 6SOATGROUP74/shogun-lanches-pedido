package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Cliente;
import com.example.demo.core.domain.Composicao;
import com.example.demo.core.domain.Pedido;
import com.example.demo.exceptions.ProdutoNotFoundException;
import com.example.demo.core.usecase.interfaces.pedido.CriarPedidoUseCasePort;
import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.BuscarPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.SalvarPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.produto.GerenciarProdutoAdapterPort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

import static com.example.demo.core.domain.StatusPedido.RECEBIDO;

public class CriarPedidoUseCase implements CriarPedidoUseCasePort {

    private static final Logger logger = LogManager.getLogger(CriarPedidoUseCase.class);

    private final SalvarPedidoAdapterPort salvarPedidoAdapterPort;
    private final GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort;
    private final RecuperarClienteAdapterPort recuperarClienteAdapterPort;
    private final BuscarPedidoAdapterPort buscarPedidoAdapterPort;

    public CriarPedidoUseCase(SalvarPedidoAdapterPort salvarPedidoAdapterPort, GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort, RecuperarClienteAdapterPort recuperarClienteAdapterPort, BuscarPedidoAdapterPort buscarPedidoAdapterPort) {
        this.salvarPedidoAdapterPort = salvarPedidoAdapterPort;
        this.gerenciarProdutoAdapterPort = gerenciarProdutoAdapterPort;
        this.recuperarClienteAdapterPort = recuperarClienteAdapterPort;
        this.buscarPedidoAdapterPort = buscarPedidoAdapterPort;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        logger.info("m=criarPedido, status=init, msg=Criando pedido={}", pedido);

        pedido.getComposicao().forEach(item -> {

            var auxProduto = gerenciarProdutoAdapterPort.buscarProdutoPorId(item.getIdProduto());
            if(Objects.isNull(auxProduto) || !auxProduto.isStatus()){
                throw new ProdutoNotFoundException("Produto nao localizado na base ou inativo");
            }
            item.setCategoria(auxProduto.getCategoria());
            item.setPrecoUnitario(auxProduto.getValor());
            item.setNomeProduto(auxProduto.getNome());
            item.setIdProduto(auxProduto.getIdProduto());
        });

        double valorTotal = 0.0;

        for(Composicao composicao : pedido.getComposicao()){
            valorTotal += composicao.getQuantidade() * composicao.getPrecoUnitario();
        }

        pedido.setCodReferenciaPedido(UUID.randomUUID().toString());
        pedido.setValorTotal(valorTotal);
        pedido.setEtapa(RECEBIDO.name());
        pedido.setDataMudancaEtapa(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        Cliente cliente = recuperarClienteAdapterPort.recuperarPorId(pedido.getCliente().getIdCliente());
        pedido.setCliente(cliente);
        Pedido pedidoCriado = salvarPedidoAdapterPort.execute(pedido);

        logger.info("m=criarPedido, status=success, msg=Pedido criado com sucesso, pedido={}", pedido);

        return buscarPedidoAdapterPort.execute(pedidoCriado.getNumeroPedido());
    }
}
