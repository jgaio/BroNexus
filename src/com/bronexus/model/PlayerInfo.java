package com.bronexus.model;

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
	public int lookupSummoner()
	{
		// this is where we look up the summoner name
		
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
