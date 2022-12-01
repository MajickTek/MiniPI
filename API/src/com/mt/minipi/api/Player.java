package com.mt.minipi.api;

import com.mt.minipi.Minicraft;
import com.mt.minipi.Vec;
import com.mt.minipi.VecFloat;

public class Player implements Entity{

	Minicraft game;
	
	public Player(Minicraft game) {
		this.game = game;
	}
	
	@Override
	public Vec getPosition() {
		game.send("player.getTile");
		return Vec.decode(game.receive());
	}

	@Override
	public void setPosition(Vec position) {
		game.send("player.setTile", position);
	}

	@Override
	public VecFloat getExactPosition() {
		game.send("player.getPos");
        return VecFloat.decode(game.receive());
	}

	@Override
	public void setExactPosition(VecFloat position) {
		game.send("player.setPos", position);
	}

	@Override
	public void setting(String key, boolean value) {
		game.send("player.setting", key, value ? 1 : 0);
	}

	@Override
	public Vec getPosition(int entityID) {
		return getPosition();
	}

	@Override
	public void setPosition(int entityID, Vec tile) {
		setPosition(tile);
	}

	@Override
	public VecFloat getExactPosition(int entityID) {
		return getExactPosition();
	}

	@Override
	public void setExactPosition(int entityID, VecFloat position) {
		setExactPosition(position);
	}
	
}