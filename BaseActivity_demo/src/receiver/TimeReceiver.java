package receiver;

import com.hehe.baseactivity_demo.SubActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TimeReceiver extends BroadcastReceiver {
	private SubActivity subActivity = new SubActivity();

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		if (intent.getAction().equals(SubActivity.TIMECHANGE_ACTION)) {
			String time = intent.getExtras().getString("time", null);
			subActivity.nowtime.setText(time);
		}
	}

}
