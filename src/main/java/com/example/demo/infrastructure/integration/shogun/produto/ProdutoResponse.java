package com.example.demo.infrastructure.integration.shogun.produto;

import java.math.BigDecimal;

public class ProdutoResponse {

    private Long idProduto;
    private BigDecimal valor;

    public ProdutoResponse() {
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
