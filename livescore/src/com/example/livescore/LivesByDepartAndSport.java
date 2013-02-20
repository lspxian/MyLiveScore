package com.example.livescore;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LivesByDepartAndSport extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lives_by_depart_and_sport);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_lives_by_depart_and_sport,
				menu);
		return true;
	}

}
