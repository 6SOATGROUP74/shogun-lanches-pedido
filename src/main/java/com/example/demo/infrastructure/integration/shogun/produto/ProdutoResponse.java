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

    public BigDecimal getValor() {
        return valor;
    }

}
