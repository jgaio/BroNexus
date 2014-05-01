package com.bronexus.model;

import java.util.List;

import com.bronexus.model.RuneSlot;

public class RunePage
{
	private boolean current;
	private long id;
	private String name;
	private List<RuneSlot> slots;
	
	public boolean isCurrent()
	{
		return current;
	}
	
	public long getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public List<RuneSlot> getSlots()
	{
		return slots;
	}
}