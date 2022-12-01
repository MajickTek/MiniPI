package com.mt.minipi.event;

import com.mt.minipi.Vec;

public abstract class TileEvent {
	public final Vec position;

	public TileEvent(Vec position) {
		this.position = position;
	}
	
	
}
