package com.mt.minipi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mt.minipi.Vec.Unit;
import com.mt.minipi.event.TileHitEvent;
import static com.mt.minipi.Vec.Unit.*;

public class EventFactory {
	public static List<TileHitEvent> createTileHitEvents(List<Integer> eventList) {
		List<TileHitEvent> events = new ArrayList<TileHitEvent>();
//		if(!eventList.isEmpty()) {
//			for(String event: eventList.split("\\|")) {
//				Scanner s = new Scanner(event).useDelimiter(",");
//				Vec position = Vec.xy(s.nextInt(), s.nextInt());
//				Vec.Unit surfaceDirection = faceIdxToDirection(s.nextInt());
//				int entityID = s.nextInt();
//				events.add(new TileHitEvent(position, surfaceDirection, entityID));
//			}
//		}
		if(eventList == null ) {
			return events;
		} else {
			Integer[] ints = (Integer[]) eventList.toArray(new Integer[eventList.size()]);
			if(ints.length >= 3) {
				Vec position = Vec.xy(ints[0], ints[1]);
				Vec.Unit surfaceDirection = faceIdxToDirection(ints[2]);
				int entityID = ints[3];
				events.add(new TileHitEvent(position, surfaceDirection, entityID));
			} else {
				System.out.println("Expected 3 integers");
			}
		}
		return events;
	}

	private static Unit faceIdxToDirection(int faceIdx) {
		Unit[] faceDirs = {Y.neg(), Y, X.neg(), X};
		
		return faceDirs[faceIdx];
	}
}
