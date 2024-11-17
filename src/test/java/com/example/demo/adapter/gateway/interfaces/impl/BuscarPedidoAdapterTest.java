//package com.example.demo.adapter.gateway.interfaces.impl;
//
//import com.example.demo.infrastructure.repository.PedidoRepository;
//import com.example.demo.infrastructure.repository.entity.PedidoEntity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.math.BigDecimal;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.when;
//
//class BuscarPedidoAdapterTest {
//
//    @Mock
//    private PedidoRepository repository;
//
//    @InjectMocks
//    private BuscarPedidoAdapter buscarPedidoAdapter;
//
//    @BeforeEach
//    void setup(){
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void executePedido_NaoDeveRetornarException() {
//        when(repository.findById(anyLong()))
//                .thenReturn(Optional.of(new PedidoEntity()));
//
//        assertDoesNotThrow(() -> buscarPedidoAdapter.execute(anyLong()));
//    }
//
//    PagamentoEntity buildPagamentoEntity(){
//
//        PagamentoEntity pagamento = new PagamentoEntity();
//        PedidoEntity pedidoEntity = new PedidoEntity();
//        pedidoEntity.setNumeroPedido(1L);
//
//        pagamento.setIdPagamento(1L);
//        pagamento.setStatus("PAGO");
//        pagamento.setPedidoEntity(pedidoEntity);
//        pagamento.setValorTotal(BigDecimal.valueOf(150.75));
//        pagamento.setTipoDoPagamento("PIX");
//        pagamento.setDataPagamento("2023-09-21");
//        pagamento.setCodPagamento("COD123456");
//        pagamento.setCopiaCola("Copia e Cola Exemplo");
//        pagamento.setQrCodeLink("https://link-para-qr-code.com");
//
//        return pagamento;
//    }
//
//}