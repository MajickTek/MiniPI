package com.mt.minipi.event;

import com.mt.minipi.Vec;

public class TileHitEvent extends TileEvent{
	public final Vec.Unit surfaceDirection;
	public final int entityID;
	
	public TileHitEvent(Vec position, Vec.Unit surfaceDirection, int entityID) {
		super(position);
		this.surfaceDirection = surfaceDirection;
		this.entityID = entityID;
		
	}

}
