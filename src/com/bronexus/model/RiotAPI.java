package com.bronexus.model;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import android.util.Log;
import android.os.*;

import com.bronexus.model.Summoner;

// google's Gson to parse the json
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;




public class RiotAPI
{
	// base url we use for every query
	private String baseUrl = "https://prod.api.pvp.net/api/lol/";
	// dev key
	private String key = "4c82d2b0-91e8-4376-bfdb-de71b1bad16d";
	
	// default constructor
	public RiotAPI()
	{
		
	}
	
	// constructor with key
	public RiotAPI(String newKey)
	{
		key = newKey;
	}
	
	// look up the summoner by their name
	public Map<String, Summoner> getSummonerByName(String name)
	{
		name = name.replaceAll("//s+", "");
		String url = baseUrl + "na/v1.4/summoner/by-name/" + name + "?api_key=" + key;
		Map<String, Summoner> summoner = null;
		try 
		{
			summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
		}
		catch (JsonSyntaxException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return summoner;
	}
}