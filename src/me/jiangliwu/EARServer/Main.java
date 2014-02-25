package me.jiangliwu.EARServer;

import java.net.InetSocketAddress;

import me.jiangliwu.EARServer.map.MapService;
import me.jiangliwu.EARServer.monster.MonsterService;
import me.jiangliwu.EARServer.npc.NpcService;
import me.jiangliwu.EARServer.util.G;



public class Main {
	public static void main(String[] args) {
		
		EARServer server = new EARServer(new InetSocketAddress(3387));
		server.setWebSocketDebug(true);
		server.start();
		
		// init all game data
		
		// init map 
		MapService.shareMap();
		NpcService.shareNpc();
		MonsterService.shareMonster();
		
	}
	
}
