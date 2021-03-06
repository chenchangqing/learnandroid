package com.example.example04;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	
	private Button sendBroadcastBtn,registerBroadcastBtn,unregisterBroadcastBtn;
	
	private final CustomBroadcast broadcast = new CustomBroadcast();

	/**
	 * ------ 生命周期 -------
	 */
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 查找发送广播的按钮
        sendBroadcastBtn = (Button) findViewById(R.id.sendBroadcastBtn);
        sendBroadcastBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				// 在演示代码注册和注销广播时，注释该创建Intent的方式
//				Intent intent = new Intent(MainActivity.this, CustomBroadcast.class);
				
				Intent intent = new Intent(CustomBroadcast.ACTION);
				intent.putExtra("kContent", "如果你要为父母做点事情，请不要等到明天！");
				
				// 发送广播
				sendBroadcast(intent);
			}
		});
        
        // 注册广播按钮
        registerBroadcastBtn = (Button) findViewById(R.id.registerBroadcastBtn);
        registerBroadcastBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				// 注册广播
				registerReceiver(broadcast, new IntentFilter(CustomBroadcast.ACTION));
			}
		});
        
        // 注销广播按钮
        unregisterBroadcastBtn = (Button) findViewById(R.id.unregisterBroadcastBtn);
        unregisterBroadcastBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				// 注销广播
				unregisterReceiver(broadcast);
			}
		});
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
}
