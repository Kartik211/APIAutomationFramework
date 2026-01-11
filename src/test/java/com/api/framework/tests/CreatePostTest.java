package com.api.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import com.api.framework.base.BaseTest;
import com.api.framework.client.ApiClient;
import com.api.framework.payload.PostPayload;

public class CreatePostTest extends BaseTest {

    @Test
    public void createPost() {

        Response response =
            ApiClient.post(
                "/posts",
                PostPayload.createPostPayload()
            );

        Assert.assertEquals(response.getStatusCode(), 201);
    }
}






