package com.hehe.custom;

import java.util.ArrayList;
import java.util.List;

import com.hehe.pojo.MenuTabItem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MenuTabHost extends TabHost {
	public final static String TAB_TAG_NEWS = "news";
	public final static String TAB_TAG_ME = "me";
	private List<MenuTabItem> tabList = new ArrayList<MenuTabItem>();

	public MenuTabHost(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MenuTabHost(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setCurrentTab(int index) {
		// TODO Auto-generated method stub
		MenuTabItem item = getMenuTabItemByIndex(index);
		if (index == getCurrentTab()) {
			if (null != item.getOnReClickListener()) {
				item.getOnReClickListener().onReClick(item);
			}
		} else {
			if (null != item.getOnBeforeClickListener()) {
				item.getOnBeforeClickListener().onBeforeClick(item);
			}
		}
		super.setCurrentTab(index);
	}

	private MenuTabItem getMenuTabItemByIndex(int index) {
		// TODO Auto-generated method stub
		return tabList.get(index);
	}

	/***
	 * 
	 */
	public void addTabMenuItem(MenuTabItem item) {
		// TODO Auto-generated method stub
		tabList.add(item);
		TabSpec spec = this.newTabSpec(item.getTag());
		spec.setContent(item.getIntent());
		spec.setIndicator(item.getView());
		addTab(spec);

	}

}
