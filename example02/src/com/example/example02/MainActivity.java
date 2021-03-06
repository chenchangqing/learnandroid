package com.example.example02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 演示android程序生命周期
 * 
 * @author green
 *
 */

public class MainActivity extends ActionBarActivity {
	
	private Button btnStartAty01;
	private TextView textView1;

	/**
	 * 	========= 生命周期 =========
	 */
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        System.out.println("onCreate");
        
        // 查找启动Aty01的按钮
        btnStartAty01 = (Button) findViewById(R.id.btnStartAty01);
        
        // 增加启动Aty01的事件
        btnStartAty01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent = new Intent(MainActivity.this, Aty01.class);
				
				// 传递数据
				intent.putExtra("kName", "LiuDeHua");
				
				// 传递数据2
				Bundle data = new Bundle();
				data.putString("kAgeDes", "My age is 26");
				intent.putExtra("data", data);
				
				/**
				 * 跳转
				 */
				
				// 不需要接受返回参数时使用
				// startActivity(intent);
				
				// 需要接受返回参数时使用
				startActivityForResult(intent, 0);
			}
		});
        
        // 查找显示返回值的文本
        textView1 = (TextView) findViewById(R.id.textView1);
    }
    
    @Override
    protected void onStart() {
    	super.onStart();

        System.out.println("onStart");
    }
    
    @Override
    protected void onResume() {
    	super.onResume();

        System.out.println("onResume");
    }

    @Override
    protected void onPause() {
    	super.onPause();

        System.out.println("onPause");
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	
    	System.out.println("onStop");
    }

    @Override
    protected void onDestroy() {
    	super.onDestroy();

        System.out.println("onDestroy");
    }
    
    @Override
    protected void onRestart() {
    	// TODO Auto-generated method stub
    	super.onRestart();

        System.out.println("onRestart");
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
	 * 	========= 接受传递的返回值 =========
	 */
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	String result = data.getStringExtra("kName");
    	textView1.setText(result);
    }
}
