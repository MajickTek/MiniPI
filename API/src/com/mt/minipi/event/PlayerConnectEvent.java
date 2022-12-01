package com.mt.minipi.event;

public class PlayerConnectEvent extends PlayerEvent{
	public final int entityID;
	
	public PlayerConnectEvent(int entityID) {
		this.entityID = entityID;
	}
}
