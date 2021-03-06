package com.example.example03;

import android.support.v7.app.ActionBarActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements OnClickListener, ServiceConnection {

	private Button startServiceBtn,stopServiceBtn,bindServiceBtn,unbindServiceBtn,getCountNumberBtn;
	
	private Intent serviceIntent;
	
	private EchoService echoService;
	
	/**
	 * ---- 生命周期 ----
	 */
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 开始ServiceBtn
        startServiceBtn = (Button) findViewById(R.id.startService);
        startServiceBtn.setOnClickListener(this);
        
        // 停止ServiceBtn
        stopServiceBtn = (Button) findViewById(R.id.stopService);
        stopServiceBtn.setOnClickListener(this);

        // 绑定ServiceBtn
        bindServiceBtn = (Button) findViewById(R.id.bindService);
        bindServiceBtn.setOnClickListener(this);
        
        // 解绑ServiceBtn
        unbindServiceBtn = (Button) findViewById(R.id.unbindService);
        unbindServiceBtn.setOnClickListener(this);
        
        // 获得当前数字
        getCountNumberBtn = (Button) findViewById(R.id.getCountNumber);
        getCountNumberBtn.setOnClickListener(this);
        
        // serviceIntent
        serviceIntent = new Intent(this,EchoService.class);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * ----- 按钮事件 开始 停止service-------
     */

	@Override
	public void onClick(View btn) {
		
		switch (btn.getId()) {
		case R.id.startService:
			
			startService(serviceIntent);
			break;
		case R.id.stopService:
			
			stopService(serviceIntent);
			break;
		case R.id.bindService:
			
			bindService(serviceIntent,this,Context.BIND_AUTO_CREATE);
			break;
		case R.id.unbindService:
			
			unbindService(this);
			echoService = null;
			break;
		case R.id.getCountNumber:
			
			if (echoService != null) {
				
				System.out.println("当前服务中的数字是：" + echoService.getCurrentNumber());
			}
			break;
		

		default:
			break;
		}
	}

	/**
	 * ----- 监听Service -----
	 */

	@Override
	public void onServiceConnected(ComponentName arg0, IBinder binder) {
		
		System.out.println("MainActivity.onServiceConnected()");
		
		// 获得Service
		echoService = ((EchoService.EchoServiceBinder)binder).getService();
	}


	@Override
	public void onServiceDisconnected(ComponentName arg0) {
		
		System.out.println("MainActivity.onServiceDisconnected()");
	}
}
