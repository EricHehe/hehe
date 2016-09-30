package com.hehe.netnew;

import com.example.baseactivity_demo.R;

import android.os.Bundle;
import android.view.View;

public class NewsActivity extends NetBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);
		View view = findViewById(R.layout.news_header);
		setNetHeader(view);
		
	}
}
