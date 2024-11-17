package com.example.demo.infrastructure.repository.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_pedido")
public class PedidoEntity {

    @Id
    @Column(name = "numero_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroPedido;

    @Column(name = "data_pedido")
    private String dataPedido;

    @Column(name = "valor_total")
    private Double valorTotal;

    @Column(name = "etapa")
    private String etapa;

    @Column(name = "data_mudanca_etapa")
    private String dataMudancaEtapa;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComposicaoEntity> composicao;

    @Column(name = "id_pagamento")
    private Long idPagamento;

    @Column(name = "cod_pedido")
    private String codPedido;

    @Column(name = "cod_referencia_pedido")
    private String codReferenciaPedido;
}
