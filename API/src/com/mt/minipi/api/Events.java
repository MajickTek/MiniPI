package com.mt.minipi.api;

import java.util.List;

import com.mt.minipi.EventFactory;
import com.mt.minipi.Minicraft;
import com.mt.minipi.event.TileHitEvent;

public class Events {
	Minicraft game;
	public Events(Minicraft game) {
		this.game = game;
	}
	
	public void clearAll() {
		game.send("events.clear");
	}
	
	public List<TileHitEvent> pollTileHits() {
        game.send("events.block.hits");
        return EventFactory.createTileHitEvents(game.receive());
    }
}
