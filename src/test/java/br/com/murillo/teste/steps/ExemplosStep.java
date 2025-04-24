package br.com.murillo.teste.steps;

import br.com.murillo.teste.service.ExemploService;
import io.cucumber.java.pt.*;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RequiredArgsConstructor
public class ExemplosStep {

    private final ExemploService service;

    Response response;

    @Dado("que eu precise criar um testes exemplo")
    public void queEuPreciseCriarUmTestesExemplo() {
    }

    @Quando("criar o codigo do teste")
    public void criarCodigoDoTeste() {

        response = service.realizarChamada("true");
    }

    @Entao("apresentar o resultado para todos")
    public void apresentarResultadoParaTodos() {

        response.then()
                .log().all()
                .statusCode(200)
                .body("valorTotalCausas", is("R$ 12,38 bi"))
                .body("quantidadeTotalProcessos", notNullValue())
                .body("ativosPorUfMapa", notNullValue());
    }

    @Quando("criar o codigo do teste negativo")
    public void criarCodigoDoTesteNegativo() {

        response = service.realizarChamada("false");
    }

    @Entao("apresentar o resultado negativo")
    public void apresentarResultadoNegativo() {

        response.then()
                .log().all()
                .statusCode(200)
                .body("valorTotalCausas", is("R$ 104,37 bi"))
                .body("quantidadeTotalProcessos", notNullValue())
                .body("ativosPorUfMapa", notNullValue());
    }

    @Quando("criar o codigo do teste para validar a mensagem")
    public void criarCodigoDoTesteParaValidarMensagem() {

        response = service.realizarChamada("teste");
    }

    @Entao("apresentar status code {int} uma mensagem {string}")
    public void apresentarStatusCodeUmaMensagem(int statusCode, String mensagem) {

        response.then()
                .log().all()
                .statusCode(statusCode)
                .body("Mensagem", is(mensagem));
    }
}
