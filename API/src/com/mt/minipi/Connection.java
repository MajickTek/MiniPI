package com.mt.minipi;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	boolean autoFlush = true;

	public Connection(String host, int port) {
		// Log.info("Connecting to " + host + ":" + port);
		System.out.printf("Connecting to %s : %d%n", host, port);
		if (host != null && !host.isEmpty()) {
			try   {
				this.socket = new Socket(host, port);
//				socket.setTcpNoDelay(true);
//				socket.setKeepAlive(true);
//				socket.setTrafficClass(0x10);
				
				
				this.in = new ObjectInputStream(socket.getInputStream());
				this.out = new ObjectOutputStream(socket.getOutputStream());
				
			} catch (IOException e) {
				throw new ConnectionException("Couldn't connect to Minicraft, is it running?");
			}
		}
		// Log.info("Connected");
		System.out.println("Connected");
	}

	public void send(Object... parts) {
		try {
			//drain(in);
			for (int i = 0; i < parts.length; i++) {
				out.writeObject(parts[i]);
			}
			
//			if (autoFlush) {
//				flush();
//			}
		} catch (IOException e) {
			throw new ConnectionException(e);
		}
	}

	public void flush() {
		try {
			out.flush();
		} catch (IOException e) {
			throw new ConnectionException(e);
		}
	}

//	public void drain(ObjectInputStream in) throws IOException {
//		while (in.ready()) {
//			int c = in.read();
//			System.err.print((char) c);
//		}
//	}

	public Object receive() {
		try {
			return in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new ConnectionException(e);
		}
	}
//
//	public void close() {//from autocloseable
//		close(in, out);
//		try {
//			socket.close();
//		} catch (IOException e) {
//		}
//	}
//
//	public void close(Closeable... cs) {
//		for (Closeable c : cs) {
//			try {
//				if (c != null) {
//					c.close();
//				}
//			} catch (IOException e) {
//			}
//		}
//	}

	public void autoFlush(boolean flush) {
		this.autoFlush = flush;
//		if (flush) {
//			flush();
//		}
	}
}
