package com.api.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import com.api.framework.base.BaseTest;
import com.api.framework.client.ApiClient;
import com.api.framework.dataprovider.PostDataProvider;

public class CreatePostDataDrivenTest extends BaseTest {
	
	@Test(dataProvider = "postData",
			dataProviderClass = PostDataProvider.class)
	public void createPostMultipleTimes(Object payload) {
		
		Response response=
				ApiClient.post("/posts", payload);
		
		Assert.assertEquals(response.getStatusCode(), 201);
	}

}
