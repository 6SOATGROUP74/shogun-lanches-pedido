package com.example.demo.infrastructure.integration.shogun.produto;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@RestClientTest(ShogunProdutoClient.class)
class ShogunProdutoClientIntegrationTest {


    private WireMockServer wireMockServer;

    @Autowired
    private ShogunProdutoClient shogunProdutoClient;

    @BeforeEach
    void setup() {
        // Inicializa o WireMock na porta 8089
        wireMockServer = new WireMockServer(8089);
        wireMockServer.start();
        WireMock.configureFor("localhost", 8089);
    }

    @AfterEach
    void teardown() {
        // Para o servidor WireMock
        wireMockServer.stop();
    }


    @Test
    void testBuscaPorId() {
        // Configura a resposta simulada do WireMock
        wireMockServer.stubFor(get(urlPathEqualTo("/v1/produtos/1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody("{\"id\": 1, \"nome\": \"Produto Teste\"}")));

        // Executa a chamada ao cliente Feign
        ProdutoResponse response = shogunProdutoClient.buscaPorId(1L);

        // Valida a resposta
        assertThat(response).isNotNull();
        assertThat(response.getIdProduto()).isEqualTo(1L);
        assertThat(response.getNome()).isEqualTo("Produto Teste");
    }
}
