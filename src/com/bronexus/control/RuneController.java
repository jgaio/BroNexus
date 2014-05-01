package com.bronexus.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.app.Activity;
import android.app.ListActivity;
import android.util.Log;

import com.example.bronexus.MainActivity;
import com.bronexus.view.RuneView;
import com.example.bronexus.R;
import com.bronexus.model.*;
import com.example.bronexus.InformationActivity;
import com.example.bronexus.RuneActivity;
import com.example.bronexus.RuneDetailActivity;

public class RuneController
{
	public class RuneStruct
	{
		int amount;
		int id;
		String name;
	}
	Activity activity;
	RuneView rView;
	PlayerInfo player;
	ArrayList<RuneStruct> runeList = new ArrayList<RuneStruct>();
	Spinner spinRunes;
	
	public RuneController(RuneActivity act)
	{
		activity = act;
	}
	public void initialize(){
		//creating the view
		activity.setContentView(R.layout.activity_rune);
		rView = new RuneView(activity);
		player = PlayerInfo.instance();
		spinRunes = (Spinner)activity.findViewById(R.id.spinRunes);
		TextView txtSummonerName = (TextView)activity.findViewById(R.id.txtSummonerNameRune);
		txtSummonerName.setText(player.getSummonerName());
		
		RunePages tempPages = player.getPages().get(String.valueOf(player.getSummonerID()));
		Set<RunePage> tempSetPages = tempPages.getPages();
		ArrayList<String> pageNames = new ArrayList<String>();
		for (RunePage tempPage : tempSetPages)
		{
			pageNames.add(tempPage.getName());
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, pageNames);
		spinRunes.setAdapter(adapter);
		
		attachEvents();
	}
	protected void goToActivity(Class<?> activityType){
		//activity.finish();
		Intent intent = new Intent(activity, activityType);
		activity.startActivity(intent);
	}
	private void attachEvents()
	{
		Button btnSubmit = (Button)activity.findViewById(R.id.btnRunesSubmit);
		btnSubmit.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				String newPageName = (String)spinRunes.getItemAtPosition(spinRunes.getSelectedItemPosition());
				player.updateCurrentRunePage(newPageName);
				goToDetailedRune();
			}
		});

	}
	private void fillRuneList(ArrayList<Integer> ids)
	{
		for (int i = 0; i < ids.size(); i++)
		{
			int tempID = ids.get(i);
			// if it exists, add to the count
			int idIndex = searchID(tempID);
			if (idIndex != -1)
			{
				RuneStruct newStruct = new RuneStruct();
				newStruct.id = tempID;
				newStruct.amount = runeList.get(idIndex).amount + 1;
				runeList.set(idIndex, newStruct);
			}
			// if it doesn't exist, add it
			else
			{
				RuneStruct newStruct = new RuneStruct();
				newStruct.id = tempID;
				newStruct.amount = 1;
				runeList.add(newStruct);
			}
		}
		fillString();
	}
	private int searchID(int id)
	{
		for (int i = 0; i < runeList.size(); i++)
		{
			if (runeList.get(i).id == id) return i;
		}
		return -1;
	}
	private void fillString()
	{
		String tempString = "";
		// right now ID, change to name later
		for (int i = 0; i < runeList.size(); i++)
		{
			String tempName = player.getRuneName(runeList.get(i).id);
			RuneStruct newStruct = new RuneStruct();
			newStruct.id = runeList.get(i).id;
			newStruct.amount = runeList.get(i).amount;
			newStruct.name = tempName;
			runeList.set(i, newStruct);
			tempString = tempString + runeList.get(i).name + "x" + runeList.get(i).amount + "\n";
		}
		player.updateCurrentRunePageText(tempString);
	}
	private void goToDetailedRune()
	{
		// prepare information to go
		Log.e("before pages", String.valueOf(player.getSummonerID()));
		RunePages tempPages = player.getPages().get(String.valueOf(player.getSummonerID()));
		Log.e("after pages", String.valueOf(tempPages.getSummonerId()));
		Set<RunePage> tempSetPages = tempPages.getPages();
		RunePage currentPage = new RunePage();
		for (RunePage tempPage : tempSetPages)
		{
			if (tempPage.getName() == player.getCurrentRunePage())
			{
				Log.e("temp page", "page found");
				currentPage = tempPage;
				break;
			}
		}
		// now we have the page, need to get the runes out of it
		List<RuneSlot> tempSlots = currentPage.getSlots();
		ArrayList<Integer> tempIDs = new ArrayList<Integer>();
		Log.e("tempSlots size", String.valueOf(tempSlots.size()));
		for (int i = 0; i < tempSlots.size(); i++)
		{	
			Log.e("tempSlot", String.valueOf(tempSlots.get(i).getRune()));
			tempIDs.add(tempSlots.get(i).getRune());
		}
		fillRuneList(tempIDs);
		// go to the screen
		Intent intent = new Intent(activity, RuneDetailActivity.class);
		activity.startActivity(intent);
	}
}