package com.example.util;

import org.json.JSONObject;

public class getDetailSport {
	protected static JSONObject getJSONObject(int i) throws Exception{
		String s=HttpUtil.getRequest("http://live-score.sqli.cloudbees.net/livescore/sport/"+i);
		JSONObject jsonObject=new JSONObject(s);
		return jsonObject;
	}
	
	public static String getNom(int i) throws Exception{
		return getJSONObject(i).getString("nom");
	}
}
