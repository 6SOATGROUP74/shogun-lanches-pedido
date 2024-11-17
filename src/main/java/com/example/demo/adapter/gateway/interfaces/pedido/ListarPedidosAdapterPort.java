package com.example.demo.adapter.gateway.interfaces.pedido;

import com.example.demo.core.domain.Pedido;

import java.util.List;

public interface ListarPedidosAdapterPort {
   List<Pedido> listarTodosPedidos();
   List<Pedido> listarPedidosOrdenados();
   Pedido buscarPedidoPorCodReferencia(String codReferencia);
}