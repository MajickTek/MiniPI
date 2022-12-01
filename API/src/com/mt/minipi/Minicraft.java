package com.mt.minipi;

import java.net.InetAddress;

import com.mt.minipi.api.Entities;
import com.mt.minipi.api.Events;
import com.mt.minipi.api.Player;
import com.mt.minipi.tool.Tools;

public class Minicraft{
	Connection connection;
	public static final int DEFAULT_PORT = 25565;

	public final Tools tools = new Tools(this);
	public final Player player = new Player(this);
	public final Entities entities = new Entities(this);
	public final Events events = new Events(this);
	
	Minicraft(Connection connection) {
		this.connection = connection;
	}

	public static Minicraft connect() {
		return connect("localhost");
	}

	public static Minicraft connect(String host) {
		return connect(host, DEFAULT_PORT);
	}

	public static Minicraft connect(String host, int port) {
		return new Minicraft(new Connection(host, port));
	}

	public static Minicraft connect(String[] args) {
		// System.err.println(Arrays.asList(args));
		String host = args.length >= 1 ? args[0] : "localhost";
		int port = args.length >= 2 ? Integer.parseInt(args[1]) : DEFAULT_PORT;
		return connect(host, port);
	}
	
	public void send(Object... parts) {
		connection.send(parts);
	}
	
	public Object receive() {
        if (!connection.autoFlush) {
            throw new IllegalStateException("Methods that return data aren't supported with autoflush off!");
        }
        return connection.receive();
    }

	public Tile getTile(Vec position) {
		send("world.getTile", Vec.encode(position));
		return Tile.decode((int)receive());
	}
	
	public void setTile(int x, int y, Tile tile) {
		setTile(Vec.xy(x, y), tile);
	}
	
	public void setTile(Vec position, Tile tile) {
		send("world.setTile", Vec.encode(position), Tile.encode(tile));
	}
	
	public void setTiles(int x1, int y1, int x2, int y2, Tile tile) {
		setTiles(Vec.xy(x1, y1), Vec.xy(x2, y2), tile);
	}
	
	public void setTiles(Vec begin, Vec end, Tile tile) {
		send("world.setTiles", Vec.encode(begin), Vec.encode(end), Tile.encode(tile));
	}
	
	public int getPlayerEntityID() {
		send("world.getPlayerID");
		int id = ((int) receive());
		return id;
	}
	
	void setting(String key, boolean value) {
		send("world.setting", key, value ? 1 : 0);
	}
	
	public void saveCheckpoint() {
		send("world.checkpoint.save");
	}
	
	public void restoreCheckpoint() {
		send("world.checkpoint.restore");
	}
	
	public void autoFlush(boolean auto) {
		connection.autoFlush(auto);
	}
	
	public void flush() {
		connection.flush();
	}
}
