package com.api.framework.auth;

import com.api.framework.utils.ConfigReader;

public class TokenManager {
	
	private static String token;
	
	public static String getToken() {
		if(token == null) {
			token = ConfigReader.getProperty("auth.token");
		}
		return token;
	}

}
