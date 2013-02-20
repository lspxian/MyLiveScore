package com.example.util;

import org.json.JSONException;
import org.json.JSONObject;

public class getDetailCompetition {
	protected static JSONObject getJSONObject(int i) throws Exception{
		String s=HttpUtil.getRequest("http://live-score.sqli.cloudbees.net/livescore/competition/"+i);
		JSONObject jsonObject=new JSONObject(s);
		return jsonObject;
	}
	
	public static String getNom(int i) throws Exception{
		return getJSONObject(i).getString("nom");
	}
	
	public static String getSportNom(int i) throws JSONException, Exception{
		return getJSONObject(i).getJSONObject("sport").getString("nom");
	}
}
