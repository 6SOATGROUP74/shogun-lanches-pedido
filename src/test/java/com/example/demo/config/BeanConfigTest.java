package com.example.demo.config;

import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.*;
import com.example.demo.adapter.gateway.interfaces.produto.GerenciarProdutoAdapterPort;
import com.example.demo.core.usecase.interfaces.cliente.RecuperarClienteUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.*;
import com.example.demo.infrastructure.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BeanConfigTest {

    private BeanConfig beanConfig;

    // Mocked dependencies
    private RecuperarClienteAdapterPort recuperarClienteAdapterPort;
    private ListarPedidosAdapterPort listarPedidosAdapterPort;
    private SalvarPedidoAdapterPort salvarPedidoAdapterPort;
    private AtualizarPedidoAdapterPort atualizarPedidoAdapterPort;
    private BuscarPedidoAdapterPort buscarPedidoAdapterPort;
    private GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort;
    private PedidoRepository pedidoRepository;

    @BeforeEach
    void setUp() {
        beanConfig = new BeanConfig();

        // Mocks
        recuperarClienteAdapterPort = Mockito.mock(RecuperarClienteAdapterPort.class);
        listarPedidosAdapterPort = Mockito.mock(ListarPedidosAdapterPort.class);
        salvarPedidoAdapterPort = Mockito.mock(SalvarPedidoAdapterPort.class);
        atualizarPedidoAdapterPort = Mockito.mock(AtualizarPedidoAdapterPort.class);
        buscarPedidoAdapterPort = Mockito.mock(BuscarPedidoAdapterPort.class);
        gerenciarProdutoAdapterPort = Mockito.mock(GerenciarProdutoAdapterPort.class);
        pedidoRepository = Mockito.mock(PedidoRepository.class);
    }

    @Test
    void testRecuperarClienteUseCasePort() {
        RecuperarClienteUseCasePort bean = beanConfig.recuperarClienteUseCasePort(recuperarClienteAdapterPort);
        assertNotNull(bean, "Bean de RecuperarClienteUseCasePort não deve ser nulo");
    }

    @Test
    void testListarPedidosUseCasePort() {
        ListarPedidosUseCasePort bean = beanConfig.listarPedidosUseCasePort(listarPedidosAdapterPort);
        assertNotNull(bean, "Bean de ListarPedidosUseCasePort não deve ser nulo");
    }

    @Test
    void testSalvarPedidoUseCasePort() {
        SalvarPedidoUseCasePort bean = beanConfig.salvarPedidoUseCasePort(salvarPedidoAdapterPort);
        assertNotNull(bean, "Bean de SalvarPedidoUseCasePort não deve ser nulo");
    }

    @Test
    void testAlterarPedidoUseCasePort() {
        BuscarPedidoUseCasePort buscarPedidoUseCasePort = Mockito.mock(BuscarPedidoUseCasePort.class);
        AlterarPedidoUseCasePort bean = beanConfig.alterarPedidoUseCasePort(atualizarPedidoAdapterPort, buscarPedidoUseCasePort);
        assertNotNull(bean, "Bean de AlterarPedidoUseCasePort não deve ser nulo");
    }

    @Test
    void testBuscarPedidoUseCasePort() {
        BuscarPedidoUseCasePort bean = beanConfig.buscarPedidoUseCasePort(pedidoRepository);
        assertNotNull(bean, "Bean de BuscarPedidoUseCasePort não deve ser nulo");
    }

    @Test
    void testCriarPedidoUseCasePort() {
        CriarPedidoUseCasePort bean = beanConfig.criarPedidoUseCasePort(
                salvarPedidoAdapterPort,
                gerenciarProdutoAdapterPort,
                recuperarClienteAdapterPort,
                buscarPedidoAdapterPort
        );
        assertNotNull(bean, "Bean de CriarPedidoUseCasePort não deve ser nulo");
    }

    @Test
    void testConclusaoPedidoUsePort() {
        SalvarPedidoUseCasePort salvarPedidoUseCasePort = Mockito.mock(SalvarPedidoUseCasePort.class);
        BuscarPedidoUseCasePort buscarPedidoUseCasePort = Mockito.mock(BuscarPedidoUseCasePort.class);
        ConclusaoPedidoUsePort bean = beanConfig.conclusaoPedidoUsePort(salvarPedidoUseCasePort, buscarPedidoUseCasePort);
        assertNotNull(bean, "Bean de ConclusaoPedidoUsePort não deve ser nulo");
    }
}
