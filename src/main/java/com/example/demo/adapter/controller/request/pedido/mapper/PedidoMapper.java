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

    @Mapping(source = "composicao", target = "composicao")
    Pedido mapFrom(PedidoRequest pedidoRequest);

    @Mapping(source = "numeroPedido", target = "numeroPedido")
    @Mapping(source = "etapa", target = "etapa")
    Pedido mapFrom(AtualizaPedidoRequest atualizaPedidoRequest);


    List<PedidoEntity> mapFrom(List<Pedido> pedidos);

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
