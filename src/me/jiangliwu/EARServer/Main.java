package me.jiangliwu.EARServer;

import java.net.InetSocketAddress;



public class Main {
	public static void main(String[] args) {
		
		EARServer server = new EARServer(new InetSocketAddress(3387));
		server.setWebSocketDebug(true);
		server.start();
	}
}
