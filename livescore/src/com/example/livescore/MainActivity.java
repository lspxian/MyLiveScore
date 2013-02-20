package com.example.livescore;

import org.json.JSONException;

import com.example.util.*;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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
		
		ListView list=(ListView) this.findViewById(R.id.lives);
		try {
			GetLives lives=new GetLives();
			ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lives.getListe());
			list.setAdapter(arrayAdapter);
			list.setOnItemClickListener(new MyOnItemClickListener());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		class MyOnItemClickListener implements OnItemClickListener{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Bundle bundle=new Bundle();
				bundle.putInt("id", arg2);
				Intent intent=new Intent(MainActivity.this,DetailLive.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
			
		
		/*
		Button bn=(Button) this.findViewById(R.id.getlive);
		bn.setOnClickListener(new MyClickListener());
	}
		class MyClickListener implements View.OnClickListener
		{
			@Override
			public void onClick(View v) {
				try {
					GetDetailLive live1=new GetDetailLive(196);
					TextView commentateur=(TextView) findViewById(R.id.commentateur);
					commentateur.setText(live1.getCommentateur());
					TextView equipe1=(TextView) findViewById(R.id.equipe1);
					equipe1.setText(live1.getEquipe1());
					TextView equipe2=(TextView) findViewById(R.id.equipe2);
					equipe2.setText(live1.getEquipe2());
					TextView scoreEquipe1=(TextView) findViewById(R.id.scoreEquipe1);
					scoreEquipe1.setText(live1.getScoreEquipe1());
					TextView scoreEquipe2=(TextView) findViewById(R.id.scoreEquipe2);
					scoreEquipe2.setText(live1.getScoreEquipe2());
					TextView sport=(TextView) findViewById(R.id.sport);
					sport.setText(live1.getSportNom());
					TextView departement=(TextView) findViewById(R.id.departement);
					departement.setText(live1.getDepartementNom());
					TextView competition=(TextView) findViewById(R.id.competition);
					competition.setText(live1.getCompititionNom());
					TextView date=(TextView) findViewById(R.id.date);
					date.setText(live1.getDebut());
					
				} catch (JSONException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}*/
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
