package com.mt.minipi.api;

import com.mt.minipi.Vec;
import com.mt.minipi.VecFloat;

public interface Entity {
	Vec getPosition();
	Vec getPosition(int entityID);
	
	void setPosition(Vec position);
	void setPosition(int entityID, Vec tile);
	
	VecFloat getExactPosition();
	VecFloat getExactPosition(int entityID);
	
	void setExactPosition(VecFloat position);
	void setExactPosition(int entityID, VecFloat position);
	
	void setting(String key, boolean value);
}
