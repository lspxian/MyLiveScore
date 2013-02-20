package com.example.util;

import org.json.JSONException;
import org.json.JSONObject;

public class GetDetailCompetition {
	protected static JSONObject getJSONObject(int i) throws Exception{
		String s=HttpUtil.getRequest("http://live-score.sqli.cloudbees.net/livescore/competition/"+i);
		JSONObject jsonObject=new JSONObject(s);
		return jsonObject;
	}
	
	public static String getNom(int i) throws Exception{
		return getJSONObject(i).getString("libelle");
	}
	
	public static String getSportNom(int i) throws JSONException, Exception{
		return getJSONObject(i).getJSONObject("sport").getString("nom");
	}
	
	public static int getId(int i) throws Exception{
		return getJSONObject(i).getInt("id");
	}
}
