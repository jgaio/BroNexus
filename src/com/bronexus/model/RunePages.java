package com.bronexus.model;

import java.util.Set;
import com.bronexus.model.RunePage;

public class RunePages 
{
	private long summonerId;
	private Set<RunePage> pages;
	
	public long getSummonerId()
	{
		return summonerId;
	}
	
	public Set<RunePage> getPages()
	{
		return pages;
	}
}