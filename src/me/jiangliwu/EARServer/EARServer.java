package me.jiangliwu.EARServer;

import java.net.InetSocketAddress;

import me.jiangliwu.EARServer.command.CommandParser;

import org.apache.log4j.Logger;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class EARServer extends WebSocketServer{

	public EARServer(InetSocketAddress address) {
		super(address);
		
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		addConnection(conn);
		
		conn.send("hello client , Welcome !");
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		removeConnection(conn);
		Logger.getLogger(EARServer.class).debug( conn.getRemoteSocketAddress() + " close !");
	}
	
	@Override
	public void onMessage(WebSocket conn, String message) {
		//System.out.println( );
		Logger.getLogger( EARServer.class).debug( " Server - onMessage " + conn.getRemoteSocketAddress() + ": " + message);
		CommandParser.getInstance().parseCommand(conn,message);
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		ex.printStackTrace();
		if( conn != null ) {
			
		}
	}
	
	public void setWebSocketDebug(boolean var){
		WebSocketImpl.DEBUG = var;
	} 

}
