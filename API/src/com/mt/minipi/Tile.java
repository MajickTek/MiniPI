package com.mt.minipi;

public class Tile {
	//TODO: add tile data
	final int id;
	String name;
	
	Tile(int id) {
		this.id = id;
	}
	
	public static Tile id(int id) {
		return new Tile(id);
	}
	
	public static Tile of(Tiles t) {
		return new Tile(t.id);
	}
	
	public Tile withName(String name) {
		setName(name);
		return this;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public static Tile decode(Integer encoded) {
		if (encoded == null ) {
			return id(0);
		} else {
			return id(encoded.intValue());
		}
		
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Tile)) {
			return false;
		}
		
		return hashCode() == ((Tile) obj).hashCode();
	}
	
	@Override
	public String toString() {
		if(!name.isEmpty()) {
			return name;
		} else {
			return "" + id;
		}
	}
}
