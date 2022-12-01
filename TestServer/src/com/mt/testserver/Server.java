package com.mt.testserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(25565)) {
			
				System.out.println("waiting for client");
				Socket socket = server.accept();
				
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				
				Object text = ois.readObject();
				System.out.println("received " + text.toString());
				
				if (text instanceof String) {
					String t = (String) text;
					if(t.equalsIgnoreCase("server.stop")) {
						ois.close();
						socket.close();
						
					}
					
				}
				
				ois.close();
				socket.close();
			
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
