package com.mt.minipi;

import com.mt.minipi.api.Entities;
import com.mt.minipi.api.Events;
import com.mt.minipi.api.Player;
import com.mt.minipi.tool.Tools;

public class Minicraft implements AutoCloseable{
	Connection connection;
	public static final int DEFAULT_PORT = 4711;

	public final Tools tools = new Tools(this);
	public final Player player = new Player(this);
	public final Entities entities = new Entities(this);
	public final Events events = new Events(this);
	
	Minicraft(Connection connection) {
		this.connection = connection;
	}

	public static Minicraft connect() {
		return connect("127.0.0.1");
	}

	public static Minicraft connect(String host) {
		return connect(host, DEFAULT_PORT);
	}

	public static Minicraft connect(String host, int port) {
		return new Minicraft(new Connection(host, port));
	}

	public static Minicraft connect(String[] args) {
		// System.err.println(Arrays.asList(args));
		String host = args.length >= 1 ? args[0] : "127.0.0.1";
		int port = args.length >= 2 ? Integer.parseInt(args[1]) : DEFAULT_PORT;
		return connect(host, port);
	}
	
	public void send(Object... parts) {
		connection.send(parts);
	}
	
	public String receive() {
        if (!connection.autoFlush) {
            throw new IllegalStateException("Methods that return data aren't supported with autoflush off!");
        }
        return connection.receive();
    }

	@Override
	public void close() throws Exception {
		connection.close();
	}
	
	
}
