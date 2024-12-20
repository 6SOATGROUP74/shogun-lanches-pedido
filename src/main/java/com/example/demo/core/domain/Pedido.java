package com.example.demo.core.domain;

import java.util.List;

public class Pedido {

    private Long numeroPedido;
    private String idCliente;
    private Double valorTotal;
    private List<Composicao> composicao;
    private String etapa;
    private Long idPagamento;
    private String dataPedido;
    private String codPedido;
    private String codReferenciaPedido;
    private String dataMudancaEtapa;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getDataMudancaEtapa() {
        return dataMudancaEtapa;
    }

    public void setDataMudancaEtapa(String dataMudancaEtapa) {
        this.dataMudancaEtapa = dataMudancaEtapa;
    }

    public String getCodReferenciaPedido() {
        return codReferenciaPedido;
    }

    public void setCodReferenciaPedido(String codReferenciaPedido) {
        this.codReferenciaPedido = codReferenciaPedido;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }


    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Composicao> getComposicao() {
        return composicao;
    }

    public void setComposicao(List<Composicao> composicao) {
        this.composicao = composicao;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

}
