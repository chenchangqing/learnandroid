package com.example.example02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Aty01 extends Activity {
	
	private Button btnClose;
	private TextView textView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty01);
		
		// 查找关闭Aty01的按钮
		btnClose = (Button) findViewById(R.id.btnClose);
		
		// 增加关闭事件
		btnClose.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				// 指定返回值
				Intent intent = new  Intent();
				intent.putExtra("kName", "ZhangXueYou");
				setResult(0, intent);
				
				finish();
			}
		});
		
		// 查找文本空间
		textView2 = (TextView) findViewById(R.id.textView2);
		
		// 设置查询参数
		String param1 = getIntent().getStringExtra("kName");
		String param2 = getIntent().getBundleExtra("data").getString("kAgeDes");
		
		textView2.setText(param1 + "," + param2);
		
	}
}
