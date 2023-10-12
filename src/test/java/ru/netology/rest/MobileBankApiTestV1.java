package ru.netology.rest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {

      given()
          .baseUri("http://localhost:9999/api/v1")

      .when()
          .get("/demo/accounts")

      .then()
          .statusCode(200);
    }

    @Test
    void shouldCheckConnectionHeader() {

        given()
                .baseUri("http://localhost:9999/api/v1")

                .when()
                .get("/demo/accounts")

                .then()
                .header("connection","keep-alive")
        ;
    }
}