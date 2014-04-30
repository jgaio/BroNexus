package com.bronexus.model;

public class SummonerStats
{
	private long id, revisionDate, summonerLevel;
	private int profileIconId;
	private String name;
	
	public long getId()
	{
		return id;
	}
	
	public long getRevisionDate()
	{
		return revisionDate;
	}
	
	public long getSummonerLevel()
	{
		return summonerLevel;
	}
	
	public long getProfileIconId()
	{
		return profileIconId;
	}
	
	public String getName()
	{
		return name;
	}
}