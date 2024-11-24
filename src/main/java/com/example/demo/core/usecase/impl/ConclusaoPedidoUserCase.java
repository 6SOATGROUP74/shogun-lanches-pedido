package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.core.usecase.interfaces.pedido.BuscarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.ConclusaoPedidoUsePort;
import com.example.demo.core.usecase.interfaces.pedido.SalvarPedidoUseCasePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Random;

public class ConclusaoPedidoUserCase implements ConclusaoPedidoUsePort {

    private static final Logger logger = LoggerFactory.getLogger(ConclusaoPedidoUserCase.class);
    private final SalvarPedidoUseCasePort salvarPedidoUseCasePort;
    private final BuscarPedidoUseCasePort buscarPedidoUseCasePort;

    public ConclusaoPedidoUserCase(SalvarPedidoUseCasePort salvarPedidoUseCasePort, BuscarPedidoUseCasePort buscarPedidoUseCasePort) {
        this.salvarPedidoUseCasePort = salvarPedidoUseCasePort;
        this.buscarPedidoUseCasePort = buscarPedidoUseCasePort;
    }

    @Override
    public Pedido execute(Pedido pedido) {

        logger.info("m=execute, msg=Concluindo o pedido - {}", pedido);

        Pedido pedidoPronto = buscarPedidoUseCasePort.buscarPorId(pedido.getNumeroPedido());
        pedidoPronto.setEtapa(StatusPedido.PRONTO.name());
        pedidoPronto.setDataMudancaEtapa(LocalDateTime.now().toString());

        // Persiste o pedido com o Status Pronto
        Pedido pedidoAlterado = salvarPedidoUseCasePort.execute(pedidoPronto);

        Random random = new Random();

        // Gera um valor aleatório entre 5 e 15 segundos para simular a retirado do pedido pelo cliente
        int tempoDeProducaoDoPedido = 5 + random.nextInt(11); // random.nextInt(11) gera de 0 a 10

        try {
            Thread.sleep(tempoDeProducaoDoPedido * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        pedidoAlterado.setEtapa(StatusPedido.FINALIZADO.name());
        pedidoAlterado.setDataMudancaEtapa(LocalDateTime.now().toString());

        Pedido pedidoFinalizado = salvarPedidoUseCasePort.execute(pedidoAlterado);

        logger.info("m=execute, msg=Pedido retirado pelo cliente - {}", pedidoFinalizado);

        return pedidoFinalizado;
    }
}
