package com.example.demo.adapter.controller;

import com.example.demo.adapter.gateway.interfaces.pagamento.RealizaPamentoAdapterPort;
import com.example.demo.core.domain.FormasPagamentoEnum;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.infrastructure.integration.shogun.pagamento.ShogunPagamentoClient;
import com.example.demo.infrastructure.integration.shogun.pagamento.request.PagamentoRequest;
import com.example.demo.infrastructure.integration.shogun.pagamento.response.PagamentoResponse;
import static com.example.demo.mocks.PedidoHelper.gerarPagamentoResponse;
import static com.example.demo.mocks.PedidoHelper.gerarPedido;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

class PagamentoControllerTest {

    private MockMvc mockMvc;

    ShogunPagamentoClient shogunPagamentoClient = mock(ShogunPagamentoClient.class);
    RealizaPamentoAdapterPort realizaPamentoAdapterPort = mock(RealizaPamentoAdapterPort.class);

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
        PagamentoController pagamentoController = new PagamentoController(shogunPagamentoClient, realizaPamentoAdapterPort);
        mockMvc = MockMvcBuilders.standaloneSetup(pagamentoController)
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
    public void deveRealizarPagamentoComSucesso() throws Exception {
        PagamentoRequest pagamentoRequest =
                PagamentoRequest.builder().numeroPedido(1L)
                        .valorTotal(BigDecimal.valueOf(3460))
                        .tipoDoPagamento(FormasPagamentoEnum.QR_CODE_PAGBANK)
                        .build();

        Pedido pedido = gerarPedido(StatusPedido.RECEBIDO.name());

        when(realizaPamentoAdapterPort.realizaPagamento(any(PagamentoRequest.class))).thenReturn(pedido);

        mockMvc.perform(post("/v1/pedido")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(pagamentoRequest)))
                .andDo(print())
                .andExpect(status().isCreated());

        verify(realizaPamentoAdapterPort, times(1)).realizaPagamento(any(PagamentoRequest.class));
    }

    @Test
    public void deveConsultarStatusPagamentoComSucesso() throws Exception {
        Long pagamentoId = 1L;
        PagamentoResponse pagamentoResponse = gerarPagamentoResponse();
        ResponseEntity<PagamentoResponse> responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(pagamentoResponse);

        when(shogunPagamentoClient.consultaStatusPagamento(pagamentoId)).thenReturn(responseEntity);

        mockMvc.perform(get("/v1/pedido/{pagamentoId}", pagamentoId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        verify(shogunPagamentoClient, times(1)).consultaStatusPagamento(anyLong());
    }

    @Test
    public void deveConfirmarPagamentoComSucesso() throws Exception {
        Long pagamentoId = 1L;
        PagamentoResponse pagamentoResponse = gerarPagamentoResponse();
        ResponseEntity<PagamentoResponse> responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(pagamentoResponse);

        when(shogunPagamentoClient.confirmaPagamento(pagamentoId)).thenReturn(responseEntity);

        mockMvc.perform(post("/v1/pedido/confirma-pagamento/{pagamentoId}", pagamentoId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

        verify(shogunPagamentoClient, times(1)).confirmaPagamento(anyLong());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}