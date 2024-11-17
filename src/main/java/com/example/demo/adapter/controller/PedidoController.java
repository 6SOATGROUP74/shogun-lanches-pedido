package com.example.demo.adapter.controller;
import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import com.example.demo.adapter.controller.request.pedido.PedidoRequest;
import com.example.demo.adapter.controller.request.pedido.mapper.PedidoMapper;
import com.example.demo.adapter.presenter.pedido.PedidoResponseMapper;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.usecase.interfaces.pedido.AlterarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.CriarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.ListarPedidosUseCasePort;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {

    private final ListarPedidosUseCasePort listarPedidosUseCasePort;
    private final CriarPedidoUseCasePort criarPedidoUseCasePort;
    private final AlterarPedidoUseCasePort alterarPedidoUseCasePort;

    private static final Logger logger = LogManager.getLogger(PedidoController.class);

    public PedidoController(ListarPedidosUseCasePort listarPedidosUseCasePort, CriarPedidoUseCasePort criarPedidoUseCasePort, AlterarPedidoUseCasePort alterarPedidoUseCasePort) {
        this.listarPedidosUseCasePort = listarPedidosUseCasePort;
        this.criarPedidoUseCasePort = criarPedidoUseCasePort;
        this.alterarPedidoUseCasePort = alterarPedidoUseCasePort;
    }

    @GetMapping
    public ResponseEntity<?> listarPedidos() {
        logger.info("m=listarPedidos, msg=Lista pedidos");
        return ResponseEntity.ok()
                .body(PedidoMapper.INSTANCE.mapFrom(listarPedidosUseCasePort.listarOrdenados()));
    }

    @PostMapping
    public ResponseEntity<?> salvarPedido(@RequestBody @Valid PedidoRequest pedidoRequest) {

        logger.info("m=salvarPedido, status=init,  msg=Cria pedido, pedidoRequest={}", pedidoRequest);

        Pedido pedidoCriado = criarPedidoUseCasePort.criarPedido(PedidoMapper.INSTANCE.mapFrom(pedidoRequest));

        logger.info("m=salvarPedido, status=success,  msg=Pedido criado com sucesso, pedidoRequest={}", pedidoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(PedidoResponseMapper.INSTANCE.mapFrom(pedidoCriado));
    }

    @PatchMapping("/atualiza")
    public ResponseEntity<?> atualizaPedido(@RequestBody AtualizaPedidoRequest atualizaPedidoRequest) {
        logger.info("m=atualizaPedido, status=init,  msg=Atualiza pedido, atualizaPedidoRequest={}", atualizaPedidoRequest);
        Pedido pedidoAlterado = PedidoMapper.INSTANCE.mapFrom(atualizaPedidoRequest);

        Pedido pedido = alterarPedidoUseCasePort.execute(pedidoAlterado);

        logger.info("m=atualizaPedido, status=success,  msg=Pedido atualizado com sucesso, atualizaPedidoRequest={}", atualizaPedidoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(PedidoResponseMapper.INSTANCE.mapFrom(pedido));
    }
}
