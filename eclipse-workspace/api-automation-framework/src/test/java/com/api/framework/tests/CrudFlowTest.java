package com.api.framework.tests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import com.api.framework.payload.PostPayload;

public class CrudFlowTest {
	
	String baseUri="https://jsonplaceholder.typicode.com";
	int postId;
	
	@Test(priority = 1)
	public void createPost() {
		
		Response response=
			given()
				.baseUri(baseUri)
				.header("Content-Type","application/json")
				.body(PostPayload.createPostPayload())
			.when()
				.post("/posts")
			.then()
				.statusCode(201)
				.extract().response();
			
		postId = response.jsonPath().getInt("id");
		Assert.assertTrue(postId > 0);
	}
	
	@Test(priority = 2)
	public void updatePayload() {
		
		String updatePayload = "{\n" +
                "  \"id\": " + postId + ",\n" +
                "  \"title\": \"Updated API Automation\",\n" +
                "  \"body\": \"Updated using PUT\",\n" +
                "  \"userId\": 1\n" +
                "}";
		
		given()
			.baseUri(baseUri)
			.header("Content-Type","application/json")
			.body(updatePayload)
		.when()
			.put("/posts/" + postId)
		.then()
			.log().all();
	}
	
	@Test(priority=3)
	public void getPost() {
		
			given()
				.baseUri(baseUri)
			.when()
				.get("/posts/"+postId)
			.then()
				.log().all();
	}
	
	@Test(priority=4)
	public void deletePost() {
		
		given()
			.baseUri(baseUri)
		.when()
			.delete("/posts/"+postId)
		.then()
			.statusCode(200);
	}
}
