package com.example.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetDetailLive {
	JSONObject jsonObject;
	JSONArray jsonArray;
	
	public GetDetailLive(int idLive) throws Exception{
		String s=HttpUtil.getRequest("http://live-score.sqli.cloudbees.net/livescore/live/"+idLive);
		jsonObject=new JSONObject(s);
		jsonArray=jsonObject.getJSONArray("evenements");
	}
	
	public String getCommentateur() throws JSONException{
		return jsonObject.getString("commentateur");
	}
	
	public String getNom() throws JSONException{
		return jsonObject.getString("nom");
	}
	
	public String getEquipe1() throws JSONException{
		return jsonObject.getString("equipe1");
	}
	
	public String getEquipe2() throws JSONException{
		return jsonObject.getString("equipe2");
	}
	
	public String getScoreEquipe1() throws JSONException{
		return jsonObject.getString("scoreEquipe1");
	}
	
	public String getScoreEquipe2() throws JSONException{
		return jsonObject.getString("scoreEquipe2");
	}
	
	public String getCompititionNom() throws JSONException{
		return jsonObject.getJSONObject("competition").getString("libelle");
	}
	
	public String getDepartementNom() throws JSONException{
		return jsonObject.getJSONObject("departement").getString("nom");
	}
	
	public String getLatitude() throws JSONException{
		return jsonObject.getString("latitude");
	}
	
	public String getLongitude() throws JSONException{
		return jsonObject.getString("longitude");
	}
	
	public String getShortDescription() throws JSONException{
		return jsonObject.getString("shortDescription");
	}
	
	public String getLongDescription() throws JSONException{
		return jsonObject.getString("longDescription");
	}
	
	public String getDebut() throws JSONException, ParseException{
		String s=jsonObject.getString("dateDebut");
		DateFormat format=DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.US);
		Date date=format.parse(s);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String sout=sdf.format(date);
		return sout;
	}
	
	public String getSportNom() throws JSONException{
		return jsonObject.getJSONObject("sport").getString("nom");
	}
	
	public int evenementSize(){
		return jsonArray.length();
	}
	
	public String getEvenement(int id) throws JSONException{
		return jsonArray.getJSONObject(id).getString("commentaire");
	}
}
