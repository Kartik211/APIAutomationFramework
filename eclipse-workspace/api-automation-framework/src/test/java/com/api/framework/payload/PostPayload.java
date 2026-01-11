package com.api.framework.payload;

public class PostPayload {
	public static String createPostPayload() {
        return "{\n" +
               "  \"title\": \"API Automation\",\n" +
               "  \"body\": \"Learning POST request\",\n" +
               "  \"userId\": 1\n" +
               "}";
    }
}
