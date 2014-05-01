package com.bronexus.control;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RemoteViews;
import android.app.Activity;

import com.example.bronexus.InformationActivity;
import com.example.bronexus.MasteryActivity;
import com.example.bronexus.RuneActivity;
import com.bronexus.view.InfoView;
import com.example.bronexus.R;
import com.bronexus.model.AggregatedStats;
import com.bronexus.model.PlayerInfo;
import com.bronexus.model.RankedStats;

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
		
		// Create Text Views
		TextView txtSummoner = (TextView)activity.findViewById(R.id.txtSummonerName);
		TextView txtDouble = (TextView)activity.findViewById(R.id.txtDoubles);
		TextView txtTriple = (TextView)activity.findViewById(R.id.txtTriples);
		TextView txtQuadra = (TextView)activity.findViewById(R.id.txtQuadras);
		TextView txtPenta = (TextView)activity.findViewById(R.id.txtPentas);
		TextView txtKill = (TextView)activity.findViewById(R.id.txtKills);
		TextView txtDeath = (TextView)activity.findViewById(R.id.txtDeaths);
		TextView txtAssist = (TextView)activity.findViewById(R.id.txtAssists);
		TextView txtWin = (TextView)activity.findViewById(R.id.txtWins);
		TextView txtLosses = (TextView)activity.findViewById(R.id.txtLosses);
		TextView txtMinion = (TextView)activity.findViewById(R.id.txtMinions);
		TextView txtTurret = (TextView)activity.findViewById(R.id.txtTurrets);
		

		
		// Set Text Views to values of respective stats
		txtSummoner.setText(player.getSummonerName() + " " + player.getSummonerID());
		txtDouble.setText("Double Kills: " + player.getDoubleKills());
		txtTriple.setText("Triple Kills: " + player.getTripleKills());
		txtQuadra.setText("Quadra Kills: " + player.getQuadraKills());
		txtPenta.setText("Penta Kills: " + player.getPentaKills());
		txtKill.setText("Kills: " + player.getChampKills());
		txtDeath.setText("Deaths: " + player.getChampDeaths());
		txtAssist.setText("Assists: " + player.getChampAssists());
		txtWin.setText("Wins: " + player.getWins());
		txtLosses.setText("Losses: " + player.getLosses());
		txtMinion.setText("Minions Killed: " + player.getMinionsKilled());
		txtTurret.setText("Turrets Destroyed: " + player.getTurretsKilled());
		
		// Iterate list for mastery pages
		/*for (int i = 0; i < 2; i++)
		{
			String temp2 = player.getMasteryNames(i);
			Button masteryButton = (Button)activity.findViewById(R.id.button1);
			masteryButton.setText(temp2);
		}*/
		


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
		Button btnMasteries = (Button)activity.findViewById(R.id.btnMasteries);
		Button btnRunes = (Button)activity.findViewById(R.id.btnRunes);
		btnMasteries.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				goToMasteries();
			}
		});
		btnRunes.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				goToRunes();
			}
		});
	}
	private void goToMasteries()
	{
		// should probably pull the mastery information here
		Intent intent = new Intent(activity, MasteryActivity.class);
		activity.startActivity(intent);
		//activity.finish();
	}
	private void goToRunes()
	{
		// should probably pull the rune information here
		Intent intent = new Intent(activity, RuneActivity.class);
		activity.startActivity(intent);
		//activity.finish();
	}
}