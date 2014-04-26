package com.bronexus.control;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;

import com.example.bronexus.InformationActivity;
import com.bronexus.view.InfoView;
import com.example.bronexus.R;
import com.bronexus.model.PlayerInfo;

public class InfoController
{
	protected Activity activity;
	protected InfoView iview;
	protected PlayerInfo player;
	
	public void initialize(){
		//creating the view
		activity.setContentView(R.layout.activity_info);
		iview = new InfoView(activity);
		player = PlayerInfo.instance();
		fillInformation();
		attachEvents();
		TextView txtSummoner = (TextView)activity.findViewById(R.id.txtSummonerName);
		txtSummoner.setText(player.getSummonerName() + " " + player.getSummonerID());
	}
	
	protected void goToActivity(Class<?> activityType){
		//activity.finish();
		Intent intent = new Intent(activity, activityType);
		activity.startActivity(intent);
	}
	
	public InfoController (InformationActivity infoAct)
	{
		activity = infoAct;
	}
	
	public void fillInformation()
	{
		// pull all the necessary information from the server and display it here
	}
	
	private void attachEvents() 
	{
		// button clicks, etc..
	}
}