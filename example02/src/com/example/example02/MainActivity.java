package com.example.example02;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 演示android程序生命周期
 * 
 * @author green
 *
 */

public class MainActivity extends ActionBarActivity {

	/**
	 * 	========= 生命周期 =========
	 */
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        System.out.println("onCreate");
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
}
