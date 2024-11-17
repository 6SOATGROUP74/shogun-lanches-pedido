package com.example.demo.core.usecase.interfaces.pedido;

import com.example.demo.core.domain.Pedido;
import java.util.List;

public interface ListarPedidosUseCasePort {
   List<Pedido> execute();
   List<Pedido> listarOrdenados();
   Pedido listarPorCodReferencia(String referencia);
}