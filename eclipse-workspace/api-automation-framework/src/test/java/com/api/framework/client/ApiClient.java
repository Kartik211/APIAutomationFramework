package com.api.framework.client;

import static io.restassured.RestAssured.*;

import java.util.Map;

import io.restassured.response.Response;
import com.api.framework.utils.ConfigReader;

public class ApiClient {

    // Object payload (generic)
    public static Response post(String endpoint, Object payload,Map<String,String>headers) {
    	return given()
                .headers(headers)
                .body(payload)
            .when()
                .post(endpoint);
    }

    // String payload (JSON)
    public static Response post(String endpoint, String payload) {
        return given()
                .header("Content-Type",
                        ConfigReader.getProperty("content.type"))
                .body(payload)
            .when()
                .post(endpoint);
    }

    public static Response put(String endpoint, Object payload) {
        return given()
                .header("Content-Type",
                        ConfigReader.getProperty("content.type"))
                .body(payload)
            .when()
                .put(endpoint);
    }

    public static Response delete(String endpoint) {
        return given()
            .when()
                .delete(endpoint);
    }
 // Object payload WITHOUT headers (used by DataProvider tests)
    public static Response post(String endpoint, Object payload) {
        return given()
                .header("Content-Type",
                        ConfigReader.getProperty("content.type"))
                .body(payload)
            .when()
                .post(endpoint);
    }
    
}

