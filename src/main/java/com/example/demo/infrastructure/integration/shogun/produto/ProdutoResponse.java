package com.example.demo.infrastructure.integration.shogun.produto;

import java.math.BigDecimal;

public class ProdutoResponse {

    private Long idProduto;
    private String nome;
    private String categoria;
    private BigDecimal valor;

    public ProdutoResponse() {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
