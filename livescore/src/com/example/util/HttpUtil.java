package com.example.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
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
	
		public static String postRequest(String url , Map<String ,String> rawParams)throws Exception
		{
			HttpPost post = new HttpPost(url);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			for(String key : rawParams.keySet())
			{
				params.add(new BasicNameValuePair(key , rawParams.get(key)));
			}
			post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			HttpResponse httpResponse = httpClient.execute(post);
			if (httpResponse.getStatusLine().getStatusCode() == 200)
			{
				String result = EntityUtils.toString(httpResponse.getEntity());
				return result;
			}
			return null;
		}
	
	public static boolean putRequest(String url,String str) throws Exception{
		HttpPut httpPut=new HttpPut(url);
		StringEntity entity=new StringEntity(str);
		httpPut.setEntity(entity);
		HttpResponse httpResponse=httpClient.execute(httpPut);
		if(httpResponse.getStatusLine().getStatusCode()==200)
		{
			return true;
			//String result=EntityUtils.toString(httpResponse.getEntity());
			//return result;
		}
		//return null;
		return false;
	}
}
