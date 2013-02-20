package com.example.util;

import java.io.IOException;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class HttpUtil
{
	public static HttpClient httpClient=new DefaultHttpClient();

	public static String getRequest(String url) throws Exception
	{
		HttpGet get=new HttpGet(url);
		HttpResponse httpResponse=httpClient.execute(get);
		if(httpResponse.getStatusLine().getStatusCode()==200)
		{
			String result=EntityUtils.toString(httpResponse.getEntity());
			return result;
		}
		return null;
	}
	
	public static void postRequest(){
	}
	
}
