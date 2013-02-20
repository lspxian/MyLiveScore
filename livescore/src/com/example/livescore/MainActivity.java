package com.example.livescore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.util.HttpUtil;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		.detectDiskReads()
		.detectDiskWrites()
		.detectNetwork() // 这里可以替换为detectAll() 就包括了磁盘读写和网络I/O
		.penaltyLog() //打印logcat，当然也可以定位到dropbox，通过文件保存相应的log
		.build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		.detectLeakedSqlLiteObjects() //探测SQLite数据库操作
		.penaltyLog() //打印logcat
		.penaltyDeath()
		.build());
		
		
		
		
		ListView list=(ListView) this.findViewById(R.id.main);
		ArrayList<String> fonctions=new ArrayList<String>();
		fonctions.add("liste des lives");
		fonctions.add("liste des departements");
		fonctions.add("liste des sports");
		fonctions.add("liste des competitions");
		
		ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fonctions);
		list.setAdapter(arrayAdapter);
		list.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				switch(arg2){
				case 0:
					Intent intent0=new Intent(MainActivity.this,ListeLives.class);
					startActivity(intent0);
					break;
				case 1:
					Intent intent1=new Intent(MainActivity.this,ListeDepartements.class);
					startActivity(intent1);
					break;
				case 2:
					Intent intent2=new Intent(MainActivity.this,ListeSports.class);
					startActivity(intent2);
					break;
				case 3:
					Intent intent3=new Intent(MainActivity.this,ListeCompetition.class);
					startActivity(intent3);
					break;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
