package com.hehe.pojo;

import com.example.baseactivity_demo.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MenuTabItem {

	private Context context;
	private String tag;
	private Intent intent;
	private String name;
	private Drawable drawable;
	private View view;
	private OnReClickListener onReClickListener;
	private OnBeforeClickListener onBeforeClickListener;

	@SuppressWarnings("deprecation")
	public MenuTabItem(Context context, String tag, Intent intent,
			Drawable drawable, String name) {
		super();
		this.context = context;
		this.tag = tag;
		this.intent = intent;
		this.drawable = drawable;
		this.name = name;
		view = LayoutInflater.from(context).inflate(R.layout.menu_tab, null);
		TextView tabname = (TextView) view.findViewById(R.id.tv_tabname);
		tabname.setText(name);
		if (drawable == null) {
			drawable = context.getResources().getDrawable(
					R.drawable.ic_launcher);
		}
		tabname.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null,
				null);
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Drawable getDrawable() {
		return drawable;
	}

	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public OnReClickListener getOnReClickListener() {
		return onReClickListener;
	}

	public void setOnReClickListener(OnReClickListener onReClickListener) {
		this.onReClickListener = onReClickListener;
	}

	public OnBeforeClickListener getOnBeforeClickListener() {
		return onBeforeClickListener;
	}

	public void setOnBeforeClickListener(
			OnBeforeClickListener onBeforeClickListener) {
		this.onBeforeClickListener = onBeforeClickListener;
	}

	public interface OnReClickListener {
		public void onReClick(MenuTabItem menuItem);
	}

	public interface OnBeforeClickListener {
		public void onBeforeClick(MenuTabItem menuItem);
	}
}
