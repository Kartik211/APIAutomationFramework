package com.api.framework.tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetUserTest {

    @Test
    public void getUserDetails() {

        given()
            .baseUri("https://jsonplaceholder.typicode.com")
        .when()
            .get("/users/1")
        .then()
            .statusCode(200)
            .log().all();
    }
}
