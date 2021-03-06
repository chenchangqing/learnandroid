package com.example.example03;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class EchoService extends Service {
	
	private final EchoServiceBinder echoServiceBinder = new EchoServiceBinder();
	
	private Timer timer;
	private TimerTask timerTask;
	
	private int i;

	@Override
	public IBinder onBind(Intent arg0) {
		
		System.out.println("EchoService.onBind()");
		return echoServiceBinder;
	}

	/**
	 * ------ 生命周期 ------
	 */
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		System.out.println("EchoService.onCreate()");
		
		startTimer();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		System.out.println("EchoService.onDestroy()");
		
		stopTimer();
	}
	
	/**
	 * ------ Timer ------
	 */
	
	private void startTimer() {
		
		if (timer == null) {
			
			timer = new Timer();
			
			timerTask = new TimerTask() {
				
				@Override
				public void run() {
					
					i++;
					
					System.out.println(i);
				}
			};
			
			// 启动 延迟一秒执行 之后每隔一秒执行
			timer.schedule(timerTask, 1000, 1000);
		}
	}
	
	private void stopTimer() {
		
		if (timer != null) {
			
			timerTask.cancel();
			timer.cancel();
			
			timerTask = null;
			timer = null;
		}
	}
	
	
	/** 
	 * ------ Binder ------
	 */
	
	public class EchoServiceBinder extends Binder {
		
		
		/**
		 * 取得Service实例
		 * @return
		 */
		public EchoService getService() {
			
			return EchoService.this;
		}
	}
	
	/**
	 * ----- 获取当前数字 ------
	 */
	
	public int getCurrentNumber() {
	
		return i;
	}
	
}
