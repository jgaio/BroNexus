package com.bronexus.control;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;

import com.example.bronexus.MainActivity;
import com.bronexus.view.MainView;
import com.example.bronexus.R;
import com.bronexus.model.PlayerInfo;
import com.example.bronexus.InformationActivity;

public class MainController
{
	protected Activity activity;
	protected MainView mview;
	protected PlayerInfo player;
	
	public void initialize(){
		//creating the view
		activity.setContentView(R.layout.activity_main);
		mview = new MainView(activity);
		player = PlayerInfo.instance();
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
	
	private void attachEvents() 
	{
		// handle button clicks, etc
		
		Button btnLookup = (Button)activity.findViewById(R.id.btnFindSummoner);
		btnLookup.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				EditText txtSummonerName = (EditText)activity.findViewById(R.id.txtSummonerName);
				String newName = (txtSummonerName.getText()).toString();
				player.setSummonerName(newName);
				player.lookupSummoner((MainActivity)activity);
			}
		});
	}
	public void goToInfo()
	{
		Intent intent = new Intent(activity, InformationActivity.class);
		activity.startActivity(intent);
		activity.finish();
	}
	public void badNameEntered()
	{
		TextView txtBadName = (TextView)activity.findViewById(R.id.txtBadName);
		txtBadName.setVisibility(View.VISIBLE);
	}
}