package com.example.livescore;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ListeDepartements extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_liste_departements);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_liste_departements, menu);
		return true;
	}

}
