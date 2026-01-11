package com.api.framework.utils;

import java.io.InputStream;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonUtil {
	
	public static List<Object> readJsonArray(String filePath){
		InputStream is=
				JsonUtil.class.getClassLoader()
					.getResourceAsStream(filePath);
		
		JsonPath jsonPath = new JsonPath(is);
		return jsonPath.getList("$");
	}

}
