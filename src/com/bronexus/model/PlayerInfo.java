package com.bronexus.model;

// dev key 4c82d2b0-91e8-4376-bfdb-de71b1bad16d
// example url for summoner with name RiotSchmick:
// https://prod.api.pvp.net/api/lol/na/v1.3/summoner/by-name/RiotSchmick?api_key=4c82d2b0-91e8-4376-bfdb-de71b1bad16d

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.os.StrictMode;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class PlayerInfo
{
	private String summonerName;
	private int numMasteries;
	private int numRunes;
	private int summonerID;
	private static PlayerInfo instance = null;
	
	// default constructor
	public PlayerInfo()
	{
		summonerName = "";
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
	//@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public int lookupSummoner()
	{
		// allows us to access the internet
		//StrictMode.ThreadPolicy policy = new StrictMode.
		//ThreadPolicy.Builder().permitAll().build();
		//StrictMode.setThreadPolicy(policy); 
		// look up the summoner name we are given
		// url with the summoner name and our key
		String url = "https:prod.api.pvp.net/api/lol/na/v1.3/summoner/by-name/RiotSchmick?api_key=4c82d2b0-91e8-4376-bfdb-de71b1bad16d";
		//String url = "https://prod.api.pvp.net/api/lol/na/v1.3/summoner/by-name/" + summonerName + "?api_key=4c82d2b0-91e8-4376-bfdb-de71b1bad16d";
		StringBuilder builder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		try 
		{
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200)
			{
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null)
				{
					builder.append(line);
				}
			}
			else
			{
				Log.e(PlayerInfo.class.toString(), "Failed to download file");
			}
		}
		catch (ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		// builder.toString() returns our response from the server
		Log.e(PlayerInfo.class.toString(), builder.toString());
		
		// if it's successful..
		// update the numMasteries
		// update the numRunes
		// update the summonerID
		// return the summoner ID
		return 0;
		// if it fails
		// return -1;
	}
	// getters for attributes
	// the only thing they should set is the name, everything else is from the lookup of the name
	public String getSummonerName()
	{
		return summonerName;
	}
	public void setSummonerName(String newName)
	{
		summonerName = newName;
	}
	public int getSummonerID()
	{
		return summonerID;
	}
	public int getNumMasteries()
	{
		return numMasteries;
	}
	public int getNumRunes()
	{
		return numRunes;
	}

}
