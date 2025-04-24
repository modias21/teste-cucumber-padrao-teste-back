package br.com.murillo.teste.service;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static io.restassured.RestAssured.given;

@Service
@RequiredArgsConstructor
@Scope(SCOPE_CUCUMBER_GLUE)
public class ExemploService {

    public void configuracoesRestAssured(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.urlEncodingEnabled = true;
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(30000L));
        RestAssured.responseSpecification = resBuilder.build();
    }

    public RequestSpecification requestBase(){

        configuracoesRestAssured();

        return given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .when();
    }

    public Response realizarChamada(String acumularValoresPeriodo){

        return requestBase()
                .log().all()
                .queryParam("somenteSindicatos", acumularValoresPeriodo)
                .queryParam("agrupamentoRankingQuantitativo", "AssuntosUltimoNivel")
                .get("https://insights.datalawyer.com.br/api/covid19");
    }
}
