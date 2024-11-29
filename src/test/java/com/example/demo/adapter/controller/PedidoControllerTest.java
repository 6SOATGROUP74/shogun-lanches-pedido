package com.example.demo.adapter.controller;

import com.example.demo.adapter.controller.request.common.ProducaoRequest;
import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import com.example.demo.adapter.controller.request.pedido.PedidoRequest;
import com.example.demo.adapter.gateway.interfaces.producao.EnviaPedidoParaProducaoAdapterPort;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.core.usecase.interfaces.pedido.AlterarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.ConclusaoPedidoUsePort;
import com.example.demo.core.usecase.interfaces.pedido.CriarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.ListarPedidosUseCasePort;
import static com.example.demo.mocks.PedidoHelper.gerarPedido;
import static com.example.demo.mocks.PedidoHelper.gerarPedidoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

class PedidoControllerTest {

    private MockMvc mockMvc;

    ListarPedidosUseCasePort listarPedidosUseCasePort = mock(ListarPedidosUseCasePort.class);
    CriarPedidoUseCasePort criarPedidoUseCasePort = mock(CriarPedidoUseCasePort.class);
    AlterarPedidoUseCasePort alterarPedidoUseCasePort = mock(AlterarPedidoUseCasePort.class);
    ConclusaoPedidoUsePort conclusaoPedidoUsePort = mock(ConclusaoPedidoUsePort.class);
    EnviaPedidoParaProducaoAdapterPort enviaPedidoParaProducaoAdapterPort = mock(EnviaPedidoParaProducaoAdapterPort.class);


    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
        PedidoController pedidoController = new PedidoController(listarPedidosUseCasePort, criarPedidoUseCasePort, alterarPedidoUseCasePort, conclusaoPedidoUsePort, enviaPedidoParaProducaoAdapterPort);
        mockMvc = MockMvcBuilders.standaloneSetup(pedidoController)
                .setControllerAdvice(new CustomExceptionHandlers())
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }, "/*")
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    AutoCloseable openMocks;

    @Test
    public void deveListarPedidosComSucesso() throws Exception {
        Pedido pedido = gerarPedido(StatusPedido.EM_PREPARACAO.name());

        when(listarPedidosUseCasePort.listarOrdenados()).thenReturn(List.of(pedido));

        mockMvc.perform(get("/v1/pedidos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        verify(listarPedidosUseCasePort, times(1)).listarOrdenados();
    }


    @Test
    public void deveSalvarPedidoComSucesso() throws Exception {
        Pedido pedido = gerarPedido(StatusPedido.RECEBIDO.name());
        PedidoRequest pedidoRequest = gerarPedidoRequest();

        when(criarPedidoUseCasePort.criarPedido(pedido)).thenReturn(pedido);

        mockMvc.perform(post("/v1/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pedidoRequest))
                )
                .andDo(print())
                .andExpect(status().isCreated());

        verify(criarPedidoUseCasePort, times(1)).criarPedido(any());
    }

    @Test
    public void deveAtualizarPedidoComSucesso() throws Exception {
        Pedido pedido = gerarPedido(StatusPedido.RECEBIDO.name());
        Pedido pedidoAlterado = gerarPedido(StatusPedido.EM_PREPARACAO.name());
        PedidoRequest pedidoRequest = gerarPedidoRequest();
        AtualizaPedidoRequest atualizaPedidoRequest = new AtualizaPedidoRequest();
        atualizaPedidoRequest.setNumeroPedido(1L);
        atualizaPedidoRequest.setEtapa(StatusPedido.EM_PREPARACAO.name());

        when(alterarPedidoUseCasePort.execute(pedido)).thenReturn(pedidoAlterado);

        mockMvc.perform(put("/v1/pedidos/atualiza")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pedidoRequest))
                )
                .andDo(print())
                .andExpect(status().isCreated());

        verify(alterarPedidoUseCasePort, times(1)).execute(any());
    }

    @Test
    public void deveEnviarPedidoComSucesso() throws Exception {
        ProducaoRequest producaoRequest = new ProducaoRequest();
        producaoRequest.setNumeroPedido(1L);
        producaoRequest.setIdPagamento(1L);
        producaoRequest.setStatusPedido(StatusPedido.EM_PREPARACAO.name());

        doNothing().when(enviaPedidoParaProducaoAdapterPort).enviaPedido(producaoRequest);

        mockMvc.perform(post("/v1/pedidos/envia-pedido")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(producaoRequest))
                )
                .andDo(print())
                .andExpect(status().isCreated());

        verify(enviaPedidoParaProducaoAdapterPort, times(1)).enviaPedido(any());
    }

    @Test
    public void deveConcluirPedidoComSucesso() throws Exception {
        AtualizaPedidoRequest atualizaPedidoRequest = new AtualizaPedidoRequest();
        atualizaPedidoRequest.setNumeroPedido(1L);
        atualizaPedidoRequest.setEtapa(StatusPedido.PRONTO.name());
        Pedido pedidoAlterado = gerarPedido(StatusPedido.PRONTO.name());

        when(conclusaoPedidoUsePort.execute(pedidoAlterado)).thenReturn(pedidoAlterado);

        mockMvc.perform(put("/v1/pedidos/notifica-producao-concluida")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(atualizaPedidoRequest))
                )
                .andDo(print())
                .andExpect(status().isCreated());

        verify(conclusaoPedidoUsePort, times(1)).execute(any());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}