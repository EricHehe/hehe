package com.example.baseactivity_demo;

import com.hehe.custom.MyDialog;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	Dialog createLoadingDialog;
	private TextView test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("主界面");
		// setleftButtontext("返回");
		setrightButtontext("跳转");
		createLoadingDialog = MyDialog.createLoadingDialog(this, "加载中...");
		initView();
		initEvents();
	}

	private void initEvents() {
		// TODO Auto-generated method stub
		test.setOnClickListener(this);
	}

	private void initView() {
		// TODO Auto-generated method stub
		test = (TextView) findViewById(R.id.test);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 super.onClick(v);
		switch (v.getId()) {
		case R.id.test:
			createLoadingDialog.show();
			break;

		default:
			break;
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		// createLoadingDialog.dismiss();
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void setRightButtonFunction() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this, SubActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
