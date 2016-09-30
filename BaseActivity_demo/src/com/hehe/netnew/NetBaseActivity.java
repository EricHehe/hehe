package com.hehe.netnew;

import com.example.baseactivity_demo.R;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class NetBaseActivity extends Activity {

	private LinearLayout ll_header;
	private LinearLayout ll_content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.netbase);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		ll_header = (LinearLayout) findViewById(R.id.ll_header);
		ll_content = (LinearLayout) findViewById(R.id.ll_content);
	}

	protected void setNetHeader(View view) {
		ll_header.addView(view, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
	};

	public void setContentView(int contentId) {
		View view = LayoutInflater.from(this).inflate(contentId, null);
		ll_content.addView(view, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
	}
}
