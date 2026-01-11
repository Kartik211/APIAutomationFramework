package com.api.framework.dataprovider;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.framework.utils.JsonUtil;


public class PostDataProvider {
	
	@DataProvider(name="postData")
	public Object[][] getPostData(){
		
		List<Object> data =
				JsonUtil.readJsonArray("testdata/postData.json");
		
		Object[][] result = new Object[data.size()][1];
		
		for(int i = 0; i< data.size();i++) {
			result[i][0]=data.get(i);
		}
		return result;
	}

}
