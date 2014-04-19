package com.bronexus.control;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.app.Activity;

import com.example.bronexus.MainActivity;
import com.bronexus.view.MainView;
import com.example.bronexus.R;

public class MainController
{
	protected Activity activity;
	protected MainView mview;
	public void initialize(){
		//creating the view
		activity.setContentView(R.layout.activity_main);
		mview = new MainView(activity);
		attachEvents();
	}
	protected void goToActivity(Class<?> activityType){
		//activity.finish();
		Intent intent = new Intent(activity, activityType);
		activity.startActivity(intent);
	}
	
	public MainController (MainActivity mainAct)
	{
		activity = mainAct;
	}
	
	private void attachEvents() {
		// handle button clicks, etc
	}
}