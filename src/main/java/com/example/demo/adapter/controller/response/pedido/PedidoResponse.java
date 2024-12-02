package com.example.demo.adapter.controller.response.pedido;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PedidoResponse {
    private String numeroPedido;
    private String idCliente;
    private List<ComposicaoResponse> composicao;
    private String valorTotal;
    private Long idPagamento;
    private String etapa;
    private String dataPedido;
    private String dataMudancaEtapa;
    private String codPedido;
    private String codReferenciaPedido;
}
