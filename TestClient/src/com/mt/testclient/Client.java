package com.mt.testclient;

import com.mt.minipi.Minicraft;

public class Client {
	public static void main(String[] args) {
		Minicraft mc = Minicraft.connect();
		mc.saveCheckpoint();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mc.send("server.stop");
	}
}
