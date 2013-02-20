package com.example.livescore;

import java.util.ArrayList;

import com.example.util.GetDetailCompetition;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
aaaaaaaaaaaaaaa
public class DetailCompetition extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_competition);
		
		ListView listView=(ListView) this.findViewById(R.id.competition);
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		int id=bundle.getInt("id");
		ArrayList<String> list=new ArrayList<String>();
		try {
			id=GetDetailCompetition.getId(id);
			list.add(GetDetailCompetition.getNom(id));
			list.add(GetDetailCompetition.getSportNom(id));
			ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
			listView.setAdapter(arrayAdapter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_detail_competition, menu);
		return true;
	}

}
