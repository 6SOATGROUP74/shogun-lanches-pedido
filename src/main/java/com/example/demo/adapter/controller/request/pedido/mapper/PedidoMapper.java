package com.example.demo.adapter.controller.request.pedido.mapper;

import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import com.example.demo.adapter.controller.request.pedido.PedidoRequest;
import com.example.demo.core.domain.Pedido;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    @Mapping(source = "idCliente", target = "cliente.idCliente")
    @Mapping(source = "composicao", target = "composicao")
    Pedido mapFrom(PedidoRequest pedidoRequest);

    @Mapping(source = "numeroPedido", target = "numeroPedido")
    Pedido mapFrom(AtualizaPedidoRequest atualizaPedidoRequest);

    @Mapping(target = "numeroPedido", source = "numeroPedido")
    List<PedidoEntity> mapFrom(List<Pedido> pedidos);

    @Mapping(target = "numeroPedido", source = "numeroPedido")
    @Mapping(target = "cliente.idCliente", source = "cliente.idCliente")
    @Mapping(target = "cliente.nome", source = "cliente.nome")
    @Mapping(target = "cliente.cpf", source = "cliente.cpf")
    @Mapping(target = "cliente.email", source = "cliente.email")
    @Mapping(target = "valorTotal", source = "valorTotal")
    @Mapping(target = "etapa", source = "etapa")
    @Mapping(target = "idPagamento", source = "idPagamento")
    @Mapping(target = "dataPedido", source = "dataPedido")
    @Mapping(target = "codPedido", source = "codPedido")
    @Mapping(target = "codReferenciaPedido", source = "codReferenciaPedido")
    @Mapping(target = "composicao", source = "composicao")
    @Mapping(target = "dataMudancaEtapa", source = "dataMudancaEtapa")
    Pedido mapFrom(PedidoEntity pedidoEntity);
}
