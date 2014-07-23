package com.example.comunicablet;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends ActionBarActivity {
	private static final String TAG = "VALUE = ";
	public static final String PREFS_NAME = "MyPrefs";
	
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View decorView = getWindow().getDecorView();
	    // Hide the status bar.
	    int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
	    decorView.setSystemUiVisibility(uiOptions);
	    // Remember that you should never show the action bar if the
	    // status bar is hidden, so hide that too if necessary.
	    ActionBar actionBar = getActionBar();
	    actionBar.hide();
	    //pref.getString("key_name", null);
	    SharedPreferences pref = getApplicationContext().getSharedPreferences(PREFS_NAME, 0); // 0 - for private mode
        String sUsername = pref.getString("USERNAME", "");
        String sRut= pref.getString("RUT", "");
		Log.v("USER",sUsername);
		Log.v("RUT",sRut);
		//String sRut = intent.getStringExtra(MainActivity.SRUT);
		// Create the text view
	    
		setContentView(R.layout.activity_main_menu);
		TextView t1 = (TextView)findViewById(R.id.username_value);
	    t1.setText(sUsername);
	    TextView t2 = (TextView)findViewById(R.id.rut_value);
	    t2.setText(sRut);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
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
	
	@Override
	public void onBackPressed() {
	    // Do nothing
	    return;
	}
	
	public void logout(View view){
		Intent intent = new Intent(this, MainActivity.class);
		SharedPreferences pref = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
		Editor editor = pref.edit();
		editor.clear();
	    editor.commit();
	    startActivity(intent);
	}
}
