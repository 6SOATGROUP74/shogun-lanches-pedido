package com.example.demo.adapter.controller;

import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import com.example.demo.adapter.controller.request.pedido.PedidoRequest;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.usecase.interfaces.pedido.AlterarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.CriarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.ListarPedidosUseCasePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PedidoControllerTest {

    @Mock
    private ListarPedidosUseCasePort listarPedidosUseCasePort;

    @Mock
    private CriarPedidoUseCasePort criarPedidoUseCasePort;

    @Mock
    private AlterarPedidoUseCasePort alterarPedidoUseCasePort;

    @InjectMocks
    private PedidoController pedidoController;


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarPedidos_DeveRetornarStatusCreated() {

        when(listarPedidosUseCasePort.listarOrdenados())
                .thenReturn(List.of(new Pedido()));

        ResponseEntity<?> responseEntity = pedidoController.listarPedidos();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void salvarPedido_DeveRetornarStatusCreated() {

        when(criarPedidoUseCasePort.criarPedido(any(Pedido.class)))
                .thenReturn(new Pedido());

        ResponseEntity<?> responseEntity = pedidoController.salvarPedido(any(PedidoRequest.class));

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    void atualizaPedido_DeveRetornarStatusCreated() {

        when(alterarPedidoUseCasePort.execute(any(Pedido.class)))
                .thenReturn(new Pedido());

        ResponseEntity<?> responseEntity = pedidoController.atualizaPedido(any(AtualizaPedidoRequest.class));

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

}