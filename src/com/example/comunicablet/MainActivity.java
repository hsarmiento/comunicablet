package com.example.comunicablet;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends ActionBarActivity {
	public static final String PREFS_NAME = "MyPrefs";
	private MediaController media_control;
	
    @TargetApi(Build.VERSION_CODES.HONEYCOMB) @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = getApplicationContext().getSharedPreferences(PREFS_NAME, 0); // 0 - for private mode
        if(pref.contains("USERNAME") && pref.contains("RUT")){
        	Intent intent = new Intent(this, MainMenuActivity.class);
        	startActivity(intent);
        }
        setContentView(R.layout.login);
        //VideoView videoHolder = (VideoView) this.findViewById(R.id.introvideo);
        
        //Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.testvideo);
        //media_control = new MediaController(this);
        //videoHolder.setMediaController(media_control);
        //videoHolder.setVideoURI(uri);
        //videoHolder.start();
        View decorView = getWindow().getDecorView();
	    // Hide the status bar.
	    int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
	    decorView.setSystemUiVisibility(uiOptions);
	    // Remember that you should never show the action bar if the
	    // status bar is hidden, so hide that too if necessary.
	    ActionBar actionBar = getActionBar();
	    actionBar.hide();
        
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
    
    public void login(View view){
    	Intent intent = new Intent(this, MainMenuActivity.class);
    	EditText username= (EditText) findViewById(R.id.username);
    	EditText rut= (EditText) findViewById(R.id.rut);
    	
    	String sUsername = username.getText().toString();
    	String sRut = rut.getText().toString();
    	
    	SharedPreferences pref = getApplicationContext().getSharedPreferences(PREFS_NAME, 0); // 0 - for private mode
        Editor editor = pref.edit();
        editor.putString("USERNAME", sUsername); // Storing string
        editor.putString("RUT", sRut); 
        editor.commit(); // commit changes
    	startActivity(intent);
    }
    
    public void presentationVideo(View view){
    	Intent intent = new Intent(this, FullScreenVideos.class);
    	startActivity(intent);
    }
}
