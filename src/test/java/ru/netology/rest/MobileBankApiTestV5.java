package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

class MobileBankApiTestV5 {
    @Test
    void shouldReturnDemoAccounts() {

      given()
          .baseUri("http://localhost:9999/api/v1")

      .when()
          .get("/demo/accounts")

      .then()
          .statusCode(200)
          .contentType(ContentType.JSON)
          .body("every{ it.balance >= 0 }", is(true))
      ;
    }

    @Test
    void shouldReturnCurrentElementValues() {

        given()
                .baseUri("http://localhost:9999/api/v1")

                .when()
                .get("/demo/accounts")

                .then()
                .body("id[0].equals(1)", is(true))
                .body("balance[2].equals(1204044)", is(true));

    }
}
