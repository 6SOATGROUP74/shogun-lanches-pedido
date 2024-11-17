package com.example.demo.adapter.controller;

import com.example.demo.adapter.controller.response.produto.ProdutoResponse;
import com.example.demo.adapter.presenter.produto.ProdutoResponseMapper;
import com.example.demo.core.usecase.interfaces.produto.GerenciarProdutoUseCasePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/categorias")
public class CategoriaController {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    private final GerenciarProdutoUseCasePort gerenciarProdutoUseCasePort;

    public CategoriaController(GerenciarProdutoUseCasePort gerenciarProdutoUseCasePort) {
        this.gerenciarProdutoUseCasePort = gerenciarProdutoUseCasePort;
    }

    @GetMapping("/{categoria}")
    public ResponseEntity<List<ProdutoResponse>> buscar(@PathVariable("categoria") final String categoria){
        return ResponseEntity.ok().body(
                ProdutoResponseMapper.INSTANCE.mapFrom(
                        gerenciarProdutoUseCasePort.buscarProdutoPorCategoria(categoria)));
    }
}
