package com.mt.minipi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Connection {
	private static final int IPTOS_LOWDELAY = 0x10;
	Socket socket;
	BufferedWriter out;
	BufferedReader in;
	boolean autoFlush = true;

	public Connection(String host, int port) {
		// Log.info("Connecting to " + host + ":" + port);
		if (host != null && !host.isEmpty()) {
			try {
				this.socket = new Socket(host, port);
				socket.setTcpNoDelay(true);
				socket.setKeepAlive(true);
				socket.setTrafficClass(IPTOS_LOWDELAY);

				this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			} catch (IOException e) {
				throw new ConnectionException("Couldn't connect to Minecraft, is it running?");
			}
		}
		// Log.info("Connected");
	}

	public void send(Object... parts) {
		try {
			drain(in);
			for (int i = 0; i < parts.length; i++) {
				out.write(parts[i].toString());
				if (i == 0) {
					out.write('(');
				} else if (i < parts.length - 1) {
					out.write(',');
				}
			}
			out.write(")\n");
			if (autoFlush) {
				flush();
			}
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

	public void drain(BufferedReader in) throws IOException {
		while (in.ready()) {
			int c = in.read();
			System.err.print((char) c);
		}
	}

	public String receive() {
		try {
			return in.readLine();
		} catch (IOException e) {
			throw new ConnectionException(e);
		}
	}

	public void close() {
		close(in, out);
		try {
			socket.close();
		} catch (IOException e) {
		}
	}

	public void close(Closeable... cs) {
		for (Closeable c : cs) {
			try {
				if (c != null) {
					c.close();
				}
			} catch (IOException e) {
			}
		}
	}

	public void autoFlush(boolean flush) {
		this.autoFlush = flush;
		if (flush) {
			flush();
		}
	}
}
