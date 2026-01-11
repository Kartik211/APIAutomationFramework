package com.api.framework.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties properties = new Properties();
	
	static{
		try {
			InputStream input = 
					ConfigReader.class
						.getClassLoader()
						.getResourceAsStream("config.properties");
			properties.load(input);
		}catch (Exception e) {
			throw new RuntimeException("Failed to load config.properties");
		}
	}
	   public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }
}
