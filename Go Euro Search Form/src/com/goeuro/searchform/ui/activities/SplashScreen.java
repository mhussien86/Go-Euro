package com.goeuro.searchform.ui.activities;

import com.goeuro.searchform.R;
import com.goeuro.searchform.common.constants.AppConstants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;


public class SplashScreen extends Activity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        
        new Handler().postDelayed(new Runnable() {
        	 
 
 
            @Override
            public void run() {
     
                Intent i = new Intent(SplashScreen.this, SearchFormActivity.class);
                startActivity(i);
 
             
                finish();
            }
        }, AppConstants.SPLASH_SCREEN_TIME_OUT);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash_screen, menu);
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
