package com.bronexus.control;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

import com.example.bronexus.MainActivity;
import com.bronexus.view.RuneView;
import com.example.bronexus.R;
import com.bronexus.model.PlayerInfo;
import com.example.bronexus.InformationActivity;
import com.example.bronexus.RuneActivity;

public class RuneController
{
	Activity activity;
	RuneView rView;
	PlayerInfo player;
	
	public RuneController(RuneActivity act)
	{
		activity = act;
	}
	public void initialize(){
		//creating the view
		activity.setContentView(R.layout.activity_rune);
		rView = new RuneView(activity);
		player = PlayerInfo.instance();
		attachEvents();
	}
	protected void goToActivity(Class<?> activityType){
		//activity.finish();
		Intent intent = new Intent(activity, activityType);
		activity.startActivity(intent);
	}
	private void attachEvents()
	{
		
	}
}