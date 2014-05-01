package com.bronexus.control;

import java.util.List;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;

import com.example.bronexus.MainActivity;
import com.bronexus.view.MasteryView;
import com.example.bronexus.R;
import com.bronexus.model.PlayerInfo;
import com.example.bronexus.InformationActivity;
import com.example.bronexus.MasteryActivity;

public class MasteryController
{
	Activity activity;
	MasteryView mView;
	PlayerInfo player;
	TextView rowTextView;
	
	public MasteryController(MasteryActivity act)
	{
		activity = act;
	}
	public void initialize(){
		//creating the view
		activity.setContentView(R.layout.activity_mastery);
		mView = new MasteryView(activity);
		player = PlayerInfo.instance();
		TextView txtSummonerName = (TextView)activity.findViewById(R.id.txtSummonerNameMastery);
		txtSummonerName.setText(player.getSummonerName());
		attachEvents();
		
		StringBuilder stringBuilder = new StringBuilder();
		List<String> masteryNameList = player.getMasteryNames();

		for (int i = 0; i < masteryNameList.size(); i++)
		{
			stringBuilder.append(masteryNameList.get(i) + "\n");
		}
		
		String masteryString = stringBuilder.toString();
		
		TextView masteryText = (TextView)activity.findViewById((R.id.mastery1));
		masteryText.setText(masteryString);

		
		//masteryText.setText(temp2);
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