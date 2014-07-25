package com.example.comunicablet;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class FullScreenVideos extends Activity {
	private MediaController media_control;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB) @SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_screen_videos);
		View decorView = getWindow().getDecorView();
	    // Hide the status bar.
	    int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
	    decorView.setSystemUiVisibility(uiOptions);
	    // Remember that you should never show the action bar if the
	    // status bar is hidden, so hide that too if necessary.
	    ActionBar actionBar = getActionBar();
	    actionBar.hide();
        VideoView videoHolder = (VideoView) this.findViewById(R.id.introvideo);
        
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.testvideo);
        media_control = new MediaController(this);
        videoHolder.setMediaController(media_control);
        videoHolder.setVideoURI(uri);
        videoHolder.start();
	}
}
