package com.api.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import com.api.framework.base.BaseTest;
import com.api.framework.client.ApiClient;
import com.api.framework.payload.PostPayload;
import com.api.framework.auth.TokenManager;
import com.api.framework.utils.HeaderUtil;

public class SecurePostTest extends BaseTest {
	
	@Test
	public void createPostWithAuth() {
		
		String token = TokenManager.getToken();
		
		Response response=
				ApiClient.post(
						"/posts", 
						PostPayload.createPostPayload(),
						HeaderUtil.getAuthHeaders(token)
						);
		
		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
