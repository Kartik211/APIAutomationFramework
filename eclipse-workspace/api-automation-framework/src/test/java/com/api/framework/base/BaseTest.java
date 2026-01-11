package com.api.framework.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import com.api.framework.utils.ConfigReader;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class BaseTest {
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = ConfigReader.getProperty("base.uri");
		
		RestAssured.filters(
		        new RequestLoggingFilter(),
		        new ResponseLoggingFilter()
		    );
	}
}
