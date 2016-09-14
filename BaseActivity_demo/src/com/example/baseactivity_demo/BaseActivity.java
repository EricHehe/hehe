package com.example.baseactivity_demo;

import com.hehe.mvp.ILoginView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BaseActivity extends Activity implements OnClickListener {
	private Button btn_leftbutton;
	private TextView tv_tiltle;
	private LinearLayout layout_content;
	private Button btn_rightbutton;
	private RelativeLayout rl_header;
	private LinearLayout ll_header;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.baseactivity);
		ll_header = (LinearLayout) findViewById(R.id.ll_header);
		rl_header = (RelativeLayout) findViewById(R.id.rl_header);
		btn_leftbutton = (Button) findViewById(R.id.btn_leftbutton);
		btn_rightbutton = (Button) findViewById(R.id.btn_rightbutton);
		tv_tiltle = (TextView) findViewById(R.id.tv_title);
		layout_content = (LinearLayout) findViewById(R.id.layout_content);
		btn_leftbutton.setOnClickListener(this);
		btn_rightbutton.setOnClickListener(this);
	}

	public void setleftButtontext(String leftbutton_text) {
		btn_leftbutton.setText(leftbutton_text);
	}

	public void setrightButtontext(String rightbutton_text) {
		btn_rightbutton.setText(rightbutton_text);
	}

	public void addHeaderView(View view) {
		rl_header.setVisibility(View.GONE);
		view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		ll_header.addView(view);
	}

	protected void setOnILoginView(ILoginView iLoginView) {
	}

	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		tv_tiltle.setText(title);
	}

	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = LayoutInflater.from(this);
		View view = inflater.inflate(layoutResID, null);
		view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		layout_content.addView(view);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (KeyEvent.KEYCODE_BACK == keyCode) {
			onBackPressed();
			overridePendingTransition(R.anim.left_in, R.anim.right_out);
			return true;
		} else
			return false;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_leftbutton:
			finish();

			overridePendingTransition(R.anim.left_in, R.anim.right_out);
			break;
		case R.id.btn_rightbutton:
			setRightButtonFunction();
			break;

		default:
			break;
		}
	}

	protected void setRightButtonFunction() {
		System.out.println("============");
	}

}
