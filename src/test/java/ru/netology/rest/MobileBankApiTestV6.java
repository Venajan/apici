package ru.netology.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;

class MobileBankApiTestV6 {
    private RequestSpecification requestSpec = new RequestSpecBuilder()
        .setBaseUri("http://localhost")
        .setBasePath("/api/v1")
        .setPort(9999)
        .setAccept(ContentType.JSON)
        .setContentType(ContentType.JSON)
        .log(LogDetail.ALL)
        .build();

    @Test
    void shouldReturnDemoAccounts() {

      given()
          .spec(requestSpec)

      .when()
          .get("/demo/accounts")

      .then()
          .statusCode(200);
    }

    @Test
    void shouldCheck() {

        given()
                .spec(requestSpec)

                .when()
                .get("/demo/accounts")

                .then()
                .statusCode(200)
                .body("name[0]", equalTo("Текущий счёт"),
                        "name[1]", equalTo("Текущий счёт"),
                        "name[2]", equalTo("Текущий зарплатный счёт"));
    }
}