package com.example.demo.adapter.controller;

import com.example.demo.adapter.controller.request.cliente.ClienteRequest;
import com.example.demo.adapter.controller.request.cliente.mapper.ClienteMapper;
import com.example.demo.adapter.presenter.cliente.ClienteResponseMapper;
import com.example.demo.core.usecase.interfaces.cliente.IncluirClienteUseCasePort;
import com.example.demo.core.usecase.interfaces.cliente.RecuperarClienteUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    private final IncluirClienteUseCasePort incluirClienteUseCasePort;
    private final RecuperarClienteUseCasePort recuperarClienteUseCasePort;

    public ClienteController(IncluirClienteUseCasePort incluirClienteUseCasePort, RecuperarClienteUseCasePort recuperarClienteUseCasePort) {
        this.incluirClienteUseCasePort = incluirClienteUseCasePort;
        this.recuperarClienteUseCasePort = recuperarClienteUseCasePort;
    }

    @PostMapping
    public ResponseEntity<?> incluir(@RequestBody @Valid ClienteRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ClienteResponseMapper.INSTANCE.mapFrom(incluirClienteUseCasePort.execute(ClienteMapper.INSTANCE.mapFrom(request))));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> recuperar(@PathVariable("cpf") final String cpf) {
        return ResponseEntity.ok()
                        .body(ClienteResponseMapper.INSTANCE.mapFrom(recuperarClienteUseCasePort.execute(cpf)));

    }
}
