package com.mt.minipi.api;

import com.mt.minipi.Minicraft;
import com.mt.minipi.Vec;
import com.mt.minipi.VecFloat;

public class Entities implements Entity{

	Minicraft game;
	
	public Entities(Minicraft game) {
		this.game = game;
	}
	
	@Override
	public Vec getPosition() {
		throw new UnsupportedOperationException("An entityID needs to be specified!");
	}

	@Override
	public void setPosition(Vec position) {
		throw new UnsupportedOperationException("An entityID needs to be specified!");
	}

	@Override
	public VecFloat getExactPosition() {
		throw new UnsupportedOperationException("An entityID needs to be specified!");
	}

	@Override
	public void setExactPosition(VecFloat position) {
		throw new UnsupportedOperationException("An entityID needs to be specified!");
	}

	@Override
	public void setting(String key, boolean value) {
		throw new UnsupportedOperationException("Entities don't have boolean settings right now!");
	}

	@Override
	public Vec getPosition(int entityID) {
		game.send("entity.getTile", entityID);
        return Vec.decode(game.receive());
	}

	@Override
	public void setPosition(int entityID, Vec tile) {
		game.send("entity.setTile", entityID, tile);
	}

	@Override
	public VecFloat getExactPosition(int entityID) {
		game.send("entity.getPos", entityID);
        return VecFloat.decode(game.receive());
	}

	@Override
	public void setExactPosition(int entityID, VecFloat position) {
		game.send("entity.setPos", entityID, position);
	}

}
