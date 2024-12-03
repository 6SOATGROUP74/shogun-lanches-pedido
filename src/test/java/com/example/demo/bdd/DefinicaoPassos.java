package com.example.demo.bdd;


import com.example.demo.adapter.controller.request.pedido.ComposicaoRequest;
import com.example.demo.adapter.controller.request.pedido.PedidoRequest;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.Arrays;

public class DefinicaoPassos {

    private Response response;

    private String ENDPOINT_PEDIDOS = "http://localhost:8091/v1/pedidos";

    @Quando("for solicitação a requisição de listagem")
    public void um_recebimento_de_uma_solicitação_de_pedidos() {
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get(ENDPOINT_PEDIDOS);
    }

    @Então("deverá retornar os pedidos com sucesso")
    public void retorno_da_chamada_de_pedidos() {
        response.then().statusCode(HttpStatus.OK.value());
    }
}
