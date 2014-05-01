package com.bronexus.model;

import java.util.List;
import java.util.Map;


public class Rune
{
	private String colloq, description, group, name, plaintext, requiredChampion, sanitizedDescription;
	private boolean consumeOnFull, consumed, hideFromAll, inStore;
	private int depth, id, specialRecipe, stacks;
	private List<String> from, into, tags;
	private Map<String, Boolean> maps;
	
	public int getId()
	{
		return id;
	}
	
	
	public String getDescription()
	{
		return description;
	}
	
	public String getName()
	{
		return name;
	}
}