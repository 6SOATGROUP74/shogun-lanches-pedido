package com.example.demo.adapter.controller;

import com.example.demo.adapter.controller.request.pedido.mapper.ProdutoMapper;
import com.example.demo.adapter.controller.request.produto.ProdutoRequest;
import com.example.demo.adapter.controller.response.produto.ProdutoResponse;
import com.example.demo.adapter.presenter.produto.ProdutoResponseMapper;
import com.example.demo.core.usecase.interfaces.produto.GerenciarProdutoUseCasePort;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    private final GerenciarProdutoUseCasePort gerenciarProdutoUseCasePort;

    public ProdutoController(GerenciarProdutoUseCasePort gerenciarProdutoUseCasePort) {
        this.gerenciarProdutoUseCasePort = gerenciarProdutoUseCasePort;
    }

    @PostMapping
    public ResponseEntity<?> incluir(@RequestBody @Valid ProdutoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoResponseMapper.INSTANCE.mapFrom(
                gerenciarProdutoUseCasePort.salvar(ProdutoMapper.INSTANCE.mapFrom(request))));
    }

    @PatchMapping("/{idProduto}")
    public ResponseEntity<?> alterar(@RequestBody @Valid ProdutoRequest request,
                                     @PathVariable("idProduto") final Long idProduto){
        return ResponseEntity.ok().body(
                ProdutoResponseMapper.INSTANCE.mapFrom(
                        gerenciarProdutoUseCasePort.alterarProduto(
                ProdutoMapper.INSTANCE.mapFrom(request), idProduto)));
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<?> deletar(@PathVariable("idProduto") final Long idProduto){
        gerenciarProdutoUseCasePort.deletarProduto(idProduto);
        return ResponseEntity.ok().build();
    }

}
