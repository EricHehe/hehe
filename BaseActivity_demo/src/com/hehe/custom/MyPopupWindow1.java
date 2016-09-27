package com.hehe.custom;

import com.example.baseactivity_demo.R;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

public class MyPopupWindow1 extends PopupWindow {
	private Context context;
	private LayoutInflater inflater;

	public MyPopupWindow1(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
		inflater = LayoutInflater.from(context);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.pop1, null);
		setContentView(view);
		setWidth(LayoutParams.MATCH_PARENT);
		setHeight(LayoutParams.MATCH_PARENT);
		setFocusable(true);
		setBackgroundDrawable(new BitmapDrawable());
	}
}
