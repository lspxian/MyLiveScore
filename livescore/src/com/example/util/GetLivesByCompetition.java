package com.example.util;

public class GetLivesByCompetition extends GetListe{
	public GetLivesByCompetition(int idCompetition) throws Exception{
		this.url="http://live-score.sqli.cloudbees.net/livescore/livesByDepartementAndSport/"+idCompetition;
		this.initial();
	}
}
