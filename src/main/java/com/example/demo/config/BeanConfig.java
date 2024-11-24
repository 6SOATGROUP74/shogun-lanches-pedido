package com.example.demo.config;

import com.example.demo.adapter.gateway.interfaces.cliente.IncluirClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.AtualizarPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.BuscarPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.ListarPedidosAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.SalvarPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.produto.GerenciarProdutoAdapterPort;
import com.example.demo.core.usecase.impl.AlterarPedidoUseCase;
import com.example.demo.core.usecase.impl.BuscarPedidoUseCase;
import com.example.demo.core.usecase.impl.ConclusaoPedidoUserCase;
import com.example.demo.core.usecase.impl.CriarPedidoUseCase;
import com.example.demo.core.usecase.impl.GerenciarProdutoUseCase;
import com.example.demo.core.usecase.impl.IncluirClienteUseCase;
import com.example.demo.core.usecase.impl.ListarPedidosUseCase;
import com.example.demo.core.usecase.impl.RecuperarClienteUseCase;
import com.example.demo.core.usecase.impl.SalvarPedidoUseCase;
import com.example.demo.core.usecase.interfaces.cliente.IncluirClienteUseCasePort;
import com.example.demo.core.usecase.interfaces.cliente.RecuperarClienteUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.AlterarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.BuscarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.ConclusaoPedidoUsePort;
import com.example.demo.core.usecase.interfaces.pedido.CriarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.ListarPedidosUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.SalvarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.produto.GerenciarProdutoUseCasePort;
import com.example.demo.infrastructure.repository.PedidoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public IncluirClienteUseCasePort incluirClienteUseCasePort(IncluirClienteAdapterPort incluirClienteAdapterPort,
                                                               RecuperarClienteAdapterPort recuperarClienteAdapterPort
                                                               ) {
        return new IncluirClienteUseCase(recuperarClienteAdapterPort, incluirClienteAdapterPort);
    }

    @Bean
    public RecuperarClienteUseCasePort recuperarClienteUseCasePort(RecuperarClienteAdapterPort recuperarClienteAdapterPort) {
        return new RecuperarClienteUseCase(recuperarClienteAdapterPort);
    }

    @Bean
    public ListarPedidosUseCasePort listarPedidosUseCasePort(ListarPedidosAdapterPort listarPedidosAdapterPort) {
        return new ListarPedidosUseCase(listarPedidosAdapterPort);
    }

    @Bean
    public SalvarPedidoUseCasePort salvarPedidoUseCasePort(SalvarPedidoAdapterPort salvarPedidoAdapterPort) {
        return new SalvarPedidoUseCase(salvarPedidoAdapterPort);
    }

    @Bean
    public GerenciarProdutoUseCasePort incluirProdutoUseCasePort(GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort) {
        return new GerenciarProdutoUseCase(gerenciarProdutoAdapterPort);
    }

    @Bean
    public AlterarPedidoUseCasePort alterarPedidoUseCasePort(AtualizarPedidoAdapterPort atualizarPedidoAdapterPort, BuscarPedidoUseCasePort buscarPedidoUseCasePort){
        return new AlterarPedidoUseCase(atualizarPedidoAdapterPort, buscarPedidoUseCasePort);
    }

    @Bean
    public BuscarPedidoUseCasePort buscarPedidoUseCasePort(PedidoRepository pedidoRepository){
        return new BuscarPedidoUseCase(pedidoRepository);
    }

    @Bean
    public CriarPedidoUseCasePort criarPedidoUseCasePort(SalvarPedidoAdapterPort salvarPedidoAdapterPort, GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort, RecuperarClienteAdapterPort recuperarClienteAdapterPort, BuscarPedidoAdapterPort buscarPedidoAdapterPort){
        return new CriarPedidoUseCase(salvarPedidoAdapterPort, gerenciarProdutoAdapterPort, recuperarClienteAdapterPort, buscarPedidoAdapterPort);
    }

    @Bean
    public ConclusaoPedidoUsePort conclusaoPedidoUsePort(SalvarPedidoUseCasePort salvarPedidoUseCasePort, BuscarPedidoUseCasePort buscarPedidoUseCasePort){
        return new ConclusaoPedidoUserCase(salvarPedidoUseCasePort, buscarPedidoUseCasePort);
    }
}
