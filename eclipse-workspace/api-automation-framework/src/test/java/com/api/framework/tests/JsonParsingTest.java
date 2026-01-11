package com.api.framework.tests;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class JsonParsingTest {

	@Test
	public void validateUsersResponse() {
		
		Response response=
				given()
					.baseUri("https://jsonplaceholder.typicode.com")
				.when()
					.get("/users")
				.then()
					.statusCode(200)
					.log().all()
					.extract().response();
		
		//Validate Response is not null
		Assert.assertNotNull(response);
		
		
		//Parse JSON array
		List<Integer> ids = response.jsonPath().getList("id");
		
		//Validate array size
		Assert.assertTrue(ids.size()>0);
		
		//Extract nested value
		String city = response.jsonPath().getString("address[0].city");
		
		Assert.assertNotNull(city);
	}
}
