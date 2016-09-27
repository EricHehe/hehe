package com.hehe.custom;

import com.example.baseactivity_demo.R;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

public class MyPopupWindow2 extends PopupWindow {

	private LayoutInflater inflater;

	public MyPopupWindow2(Context context) {
		super(context);
		inflater = LayoutInflater.from(context);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.pop2, null);
		setContentView(view);
		setWidth(LayoutParams.WRAP_CONTENT);
		setHeight(LayoutParams.WRAP_CONTENT);
		setFocusable(true);
		setBackgroundDrawable(new BitmapDrawable());
		
	}

}
