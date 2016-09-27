package com.hehe.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.hehe.baseactivity_demo.SubActivity;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class TimeService extends Service{

	private SimpleDateFormat sdf;
	private Timer timer;
	private Intent intent;
	private Bundle bundle;
	@SuppressLint("SimpleDateFormat") @Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timer = new Timer();
		intent = new Intent();
		bundle = new Bundle();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				intent.setAction(SubActivity.TIMECHANGE_ACTION);
				bundle.putString("time", sdf.format(new Date()));
				intent.putExtras(bundle);
				sendBroadcast(intent);
			}
		}, 0, 1000);
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		timer.cancel();
	}

}
