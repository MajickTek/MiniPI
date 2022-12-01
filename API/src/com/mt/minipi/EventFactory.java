package com.mt.minipi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mt.minipi.Vec.Unit;
import com.mt.minipi.event.TileHitEvent;
import static com.mt.minipi.Vec.Unit.*;

public class EventFactory {
	public static List<TileHitEvent> createTileHitEvents(String eventList) {
		List<TileHitEvent> events = new ArrayList<TileHitEvent>();
		if(eventList != null && eventList.isEmpty()) {
			for(String event: eventList.split("\\|")) {
				try (Scanner s = new Scanner(event).useDelimiter(",")) {
					Vec position = Vec.xy(s.nextInt(), s.nextInt());
					Vec.Unit surfaceDirection = faceIdxToDirection(s.nextInt());
					int entityID = s.nextInt();
					events.add(new TileHitEvent(position, surfaceDirection, entityID));
				}
			}
		}
		
		return events;
	}

	private static Unit faceIdxToDirection(int faceIdx) {
		Unit[] faceDirs = {Y.neg(), Y, X.neg(), X};
		
		return faceDirs[faceIdx];
	}
}
