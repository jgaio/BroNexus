package com.bronexus.model;

// dev key 4c82d2b0-91e8-4376-bfdb-de71b1bad16d
// example url for summoner with name RiotSchmick:
// https://prod.api.pvp.net/api/lol/na/v1.3/summoner/by-name/RiotSchmick?api_key=4c82d2b0-91e8-4376-bfdb-de71b1bad16d


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.os.StrictMode;
import android.app.Activity;

import com.bronexus.model.RiotAPI;
import com.bronexus.model.Summoner;
import com.example.bronexus.InformationActivity;
import com.example.bronexus.MainActivity;

import java.util.Map;

public class PlayerInfo
{
	private String summonerName;
	private MainActivity activity;
	private int numMasteries;
	private int numRunes;
	private long summonerID;
	private static PlayerInfo instance = null;
	private RiotAPI riot;
	private boolean toInfo;
	
	// default constructor
	public PlayerInfo()
	{
		summonerName = "";
		riot = new RiotAPI("4c82d2b0-91e8-4376-bfdb-de71b1bad16d");
		reset();
	}
	// constructor with the player's name
	public PlayerInfo(String newName)
	{
		summonerName = newName;
		reset();
	}
	// reset the stats
	private void reset()
	{
		toInfo = false;
		numMasteries = -1;
		numRunes = -1;
		summonerID = -1;
	}
	// use this to pass the instance of this singleton object around
	public static PlayerInfo instance()
	{
		if (instance == null)
		{
			instance = new PlayerInfo();
		}
		return instance;
	}
	//preventing the cloning of this single instance
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
    }
    // check if the summoner name is valid
	public void lookupSummoner(MainActivity newAct)
	{
		activity = newAct;
		// let the RiotAPI handle it
		Thread thread = new Thread(new Runnable(){
		    @Override
		    public void run() {
		        try {
		        	Map<String, Summoner> newSum =  riot.getSummonerByName(summonerName);
		    		
		    		if (newSum != null)
		    		{
		    			Summoner summoner = newSum.get(summonerName);
		    			summonerID = summoner.getId();
		    			if (summonerID != -1)
		    			{
		    				toInfo = true;
		    			}
		    		}
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		});
		thread.start();
		while (thread.isAlive())
		{
			// indefinite wait until our code is executed and we are back on main thread
		}
		if (toInfo)
		{
			// summoner is valid, move to the next screen
			goToInfo();
		}
		else
		{
			// output to the player that the name is not valid
			activity.badNameEntered();
		}
		
	}
	// getters for attributes
	public String getSummonerName()
	{
		return summonerName;
	}
	public void setSummonerName(String newName)
	{
		summonerName = newName;
	}
	public long getSummonerID()
	{
		return summonerID;
	}
	public void setSummonerID(long newSummID)
	{
		summonerID = newSummID;
	}
	public int getNumMasteries()
	{
		return numMasteries;
	}
	public int getNumRunes()
	{
		return numRunes;
	}
	private void goToInfo()
	{
		activity.goToInfo();
	}

}
