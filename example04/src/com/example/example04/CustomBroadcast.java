package com.example.example04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CustomBroadcast extends BroadcastReceiver {
	
	/**
	 * 格式：包名 + intent.action + 类名
	 */
	public static final String ACTION = "com.example.example04.intent.action.CustomBroadcast";

	@Override
	public void onReceive(Context arg0, Intent intent) {

		System.out.println("CustomBroadcast.onReceive()");
		
		// 输出广播传递的参数
		String content = intent.getStringExtra("kContent");
		System.out.println(content);
	}

}
