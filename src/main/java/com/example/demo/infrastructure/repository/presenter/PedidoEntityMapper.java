package com.example.demo.infrastructure.repository.presenter;

import com.example.demo.core.domain.Pedido;
import com.example.demo.infrastructure.repository.entity.PedidoEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Mapper(uses = ComposicaoEntityMapper.class)
public interface PedidoEntityMapper {

    PedidoEntityMapper INSTANCE = Mappers.getMapper(PedidoEntityMapper.class);

    @Mapping(target = "dataPedido", expression = "java(dataHoraAtual())")
    PedidoEntity mapFrom(Pedido pedido);

    @Mapping(target =  "numeroPedido", source = "pedidoEntity.numeroPedido")
    @Mapping(target =  "cliente", source = "pedidoEntity.cliente")
    @Mapping(target =  "valorTotal", source = "pedidoEntity.valorTotal")
    @Mapping(target =  "composicao", source = "pedidoEntity.composicao")
    @Mapping(target =  "idPagamento", source = "pedidoEntity.idPagamento")
    @Mapping(target =  "dataPedido", source = "pedidoEntity.dataPedido")
    @Mapping(target =  "codPedido", source = "pedidoEntity.codPedido")
    @Mapping(target =  "codReferenciaPedido", source = "pedidoEntity.codReferenciaPedido")
    @Mapping(target =  "dataMudancaEtapa", source = "pedidoEntity.dataMudancaEtapa")
    Pedido mapFrom(PedidoEntity pedidoEntity);
    List<Pedido> mapFrom(List<PedidoEntity> pedidoEntity);

    @Mapping(target = "dataMudancaEtapa", expression = "java(dataHoraAtual())")
    @Mapping(target =  "idPagamento", source = "idPagamento")
    PedidoEntity updateFrom(Pedido pedido);

    default String dataHoraAtual() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @AfterMapping
    default PedidoEntity afterMapping(@MappingTarget PedidoEntity entity, Pedido pedido){
        entity.getComposicao().forEach(item -> {
            item.setPedido(entity);
        });
        entity.setCodReferenciaPedido(pedido.getCodReferenciaPedido());
        entity.setDataMudancaEtapa(dataHoraAtual());

        return entity;

    }

    Pedido mapFrom(Optional<PedidoEntity> pedidoEntity);
}
