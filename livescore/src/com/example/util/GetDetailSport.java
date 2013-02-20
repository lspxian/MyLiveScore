package com.example.util;

import org.json.JSONObject;

public class GetDetailSport {
	
	protected static JSONObject getJSONObject(int id) throws Exception{
		String s=HttpUtil.getRequest("http://live-score.sqli.cloudbees.net/livescore/sport/"+id);
		JSONObject jsonObject=new JSONObject(s);
		return jsonObject;
	}
	
	public static String getNom(int i) throws Exception{
		return getJSONObject(i).getString("nom");
	}
	
	public static int getId(int i) throws Exception{
		return getJSONObject(i).getInt("id");
	}
}
