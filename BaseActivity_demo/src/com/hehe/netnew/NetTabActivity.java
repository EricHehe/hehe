package com.hehe.netnew;

import com.example.baseactivity_demo.R;
import com.hehe.custom.MenuTabHost;
import com.hehe.pojo.MenuTabItem;
import com.hehe.pojo.MenuTabItem.OnBeforeClickListener;
import com.hehe.pojo.MenuTabItem.OnReClickListener;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;

@SuppressWarnings("deprecation")
public class NetTabActivity extends TabActivity {

	private MenuTabHost tabHost;
	private Intent newsIntent;
	private Intent meIntent;
	private MenuTabItem newsMenuTabItem;
	private MenuTabItem meMenuTabItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.net_tab);
		setTabIntent();
		initTabHost();
	}

	private void initTabHost() {
		// TODO Auto-generated method stub
		tabHost = (MenuTabHost) getTabHost();
		newsMenuTabItem = new MenuTabItem(this, MenuTabHost.TAB_TAG_NEWS,
				newsIntent, null, "news");
		newsMenuTabItem.setOnReClickListener(new OnReClickListener() {
			
			@Override
			public void onReClick(MenuTabItem menuItem) {
				// TODO Auto-generated method stub
//				menuItem.setName("reclick");
				System.out.println("onreclick================");
			}
		});
		meMenuTabItem = new MenuTabItem(this, MenuTabHost.TAB_TAG_ME, meIntent,
				null, "me");
		meMenuTabItem.setOnBeforeClickListener(new OnBeforeClickListener() {
			
			@Override
			public void onBeforeClick(MenuTabItem menuItem) {
				// TODO Auto-generated method stub
//				menuItem.setName("before");
				System.out.println("onbefore==============");
			}
		});
		tabHost.addTabMenuItem(newsMenuTabItem);
		tabHost.addTabMenuItem(meMenuTabItem);

	}

	private void setTabIntent() {
		// TODO Auto-generated method stub
		newsIntent = new Intent(this, NewsActivity.class);
		meIntent = new Intent(this, MeActivity.class);
	}
}
