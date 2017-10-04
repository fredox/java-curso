package com.privalia.dao;

import java.util.UUID;

public class PrivaliaObject {
	public UUID id;
	
	public PrivaliaObject()
	{
		this.id = UUID.randomUUID();
	}
	
	public String getUuid()
	{
		return id.toString();
	}
}
