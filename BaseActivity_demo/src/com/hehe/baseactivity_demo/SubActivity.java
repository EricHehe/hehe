package com.hehe.baseactivity_demo;

import receiver.TimeReceiver;

import com.example.baseactivity_demo.R;
import com.hehe.custom.MyPopupWindow1;
import com.hehe.service.TimeService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SubActivity extends BaseActivity {

	public final static String TIMECHANGE_ACTION = "com.hehe.SubActiviry";
	private ConnectivityManager connectivityManager;
	private IntentFilter intentFilter;
	private BroadcastReceiver receiver;
	private TimeReceiver timeReceiver;
	public static TextView nowtime;
	private Intent intent;
	private TextView tv_pop1;
	private TextView tv_pop2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		setleftButtontext("返回");
		setrightButtontext("login");
		setTitle("sub界面");
		initView();
		initEvents();
		initNetworkChange();
		initTime();
	}

	private void initEvents() {
		// TODO Auto-generated method stub
		tv_pop1.setOnClickListener(this);
		tv_pop2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		super.onClick(v);
		switch (v.getId()) {
		case R.id.tv_pop1:
			MyPopupWindow1 myPopupWindow1 = new MyPopupWindow1(SubActivity.this);
			myPopupWindow1.showAsDropDown(v);
			break;
		case R.id.tv_pop2:

			break;

		default:
			break;
		}

	}

	private void initView() {
		// TODO Auto-generated method stub
		nowtime = (TextView) findViewById(R.id.tv_nowtime);
		tv_pop1 = (TextView) findViewById(R.id.tv_pop1);
		tv_pop2 = (TextView) findViewById(R.id.tv_pop2);
	}

	private void initTime() {
		// TODO Auto-generated method stub
		timeReceiver = new TimeReceiver();
		IntentFilter filter = new IntentFilter(TIMECHANGE_ACTION);
		registerReceiver(timeReceiver, filter);
		intent = new Intent(this, TimeService.class);
		startService(intent);
	}

	private void initNetworkChange() {
		// TODO Auto-generated method stub
		connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		intentFilter = new IntentFilter();
		intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		receiver = new BroadcastReceiver() {

			@SuppressWarnings("deprecation")
			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				if (intent.getBooleanExtra(
						ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)) {
					Log.i(SubActivity.this.getClass().getName(),
							"network has lost");
				} else {
					NetworkInfo networkInfo = (NetworkInfo) intent.getExtras()
							.get(ConnectivityManager.EXTRA_NETWORK_INFO);

					Log.i(SubActivity.this.getClass().getName(), networkInfo
							+ "isconnected" + networkInfo.isConnected());
					if (networkInfo.getTypeName().equals("WIFI")) {
						System.out.println("===============wifi=====");
					}

				}

			}
		};
		registerReceiver(receiver, intentFilter);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(receiver);
		unregisterReceiver(timeReceiver);
		stopService(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub, menu);
		return true;
	}

	@Override
	protected void setRightButtonFunction() {
		// TODO Auto-generated method stub
		super.setRightButtonFunction();
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
