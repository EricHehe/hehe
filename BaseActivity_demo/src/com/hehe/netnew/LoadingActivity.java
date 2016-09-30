package com.hehe.netnew;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class LoadingActivity extends Activity {

	private Dialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ImageView imageView = new ImageView(this);
		imageView.setBackgroundColor(Color.BLACK);
		setContentView(imageView, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		dialog = new Dialog(this);
		dialog.show();
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				startActivity(new Intent(LoadingActivity.this,
						NetTabActivity.class));
				finish();
			}
		}, 2000);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		dialog.cancel();
	}

}
