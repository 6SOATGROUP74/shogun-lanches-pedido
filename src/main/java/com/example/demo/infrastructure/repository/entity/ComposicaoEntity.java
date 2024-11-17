package com.example.demo.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_composicao_pedido")
@Getter
@Setter
public class ComposicaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_composicao")
    private Long idComposicao;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "preco_unitario")
    private double precoUnitario;

    @ManyToOne
    @JoinColumn(name = "numero_pedido")
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private ProdutoEntity produto;
}
