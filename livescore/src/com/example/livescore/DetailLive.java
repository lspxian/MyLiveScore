package com.example.livescore;

import java.util.ArrayList;

import com.example.util.GetDetailLive;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ListView;

public class DetailLive extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_live);
		
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
		
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		int id=bundle.getInt("id");
		ListView listView=(ListView) this.findViewById(R.id.live);
		try {
			GetDetailLive live=new GetDetailLive(id);
			ArrayList<String> list=new ArrayList<String>();
			list.add(live.getDepartementNom());
			list.add(live.getSportNom());
			list.add(live.getCompititionNom());
			list.add(live.getCommentateur());
			list.add(live.getDebut());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_detail_live, menu);
		return true;
	}

}
