package com.example.livescore;

import org.json.JSONException;

import com.example.util.GetLives;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListeLives extends Activity {

	GetLives lives;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_liste_lives);
		
		ListView list=(ListView) this.findViewById(R.id.lives);
		try {
			lives=new GetLives();
			ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lives.getListe());
			list.setAdapter(arrayAdapter);
			list.setOnItemClickListener(new OnItemClickListener(){
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					Bundle bundle=new Bundle();
					try {
						bundle.putInt("id", lives.getId(arg2));
					} catch (JSONException e) {
						e.printStackTrace();
					}
					Intent intent=new Intent(ListeLives.this,DetailLive.class);
					intent.putExtras(bundle);
					startActivity(intent);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_liste_lives, menu);
		return true;
	}

}
