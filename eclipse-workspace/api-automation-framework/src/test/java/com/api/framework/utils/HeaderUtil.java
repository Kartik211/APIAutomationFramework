package com.api.framework.utils;

import java.util.HashMap;
import java.util.Map;

public class HeaderUtil {
	
	public static Map<String, String> getDefaultHeaders(){
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type",
				ConfigReader.getProperty("content.type"));
		return headers;
	}
	
	public static Map<String, String> getAuthHeaders(String token){
		Map<String, String> headers=getDefaultHeaders();
		headers.put("Authorization","Bearer"+ token);
		return headers;
	}
	
	public static Map<String,String> getApiKeyHeaders(){
		Map<String, String> headers=getDefaultHeaders();
		headers.put("x-api-key",
				ConfigReader.getProperty("api.key"));
		return headers;
	}
}
