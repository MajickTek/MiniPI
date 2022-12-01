package com.mt.testclient;

import com.mt.minipi.Minicraft;

public class Client {
	public static void main(String[] args) {
		Minicraft mc = Minicraft.connect();
		mc.saveCheckpoint();
		
	}
}
