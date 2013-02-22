package com.example.livescore;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Main_page extends Activity {
	
	private Button button_1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		
		// Listen for button clicks
		findViews();
	}

	private void findViews() {
		button_1 = (Button) findViewById(R.id.main_button_1);
	}
	
	public void add(View v) {
			Intent intent = new Intent();
			intent.setClass(Main_page.this, Add_page.class);
			startActivity(intent);
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_page, menu);
		return true;
	}

}
