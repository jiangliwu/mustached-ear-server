package me.jiangliwu.EARServer.monster;

import java.util.LinkedList;
import java.util.List;

import org.java_websocket.WebSocket;
import org.json.JSONArray;


import me.jiangliwu.EARServer.util.DB;
import me.jiangliwu.EARServer.util.G;

public class MonsterService {

	public static void shareMonster() {
		for (Object key : G.getInstance().getGame().keySet()) {

			List<Object> queryArgs = new LinkedList<Object>();
			queryArgs.add(key);
			List<?> npcList = DB.findByQuery("from " + Monster.class.getName()
					+ " as model where model.map.id" + "= ?", queryArgs);
			G.getInstance().getGame().get(key).put("npc", npcList);
		}
	}
	
	/**
	 * 广播给本地图的其他人，以显示怪物掉血了
	 * @param con
	 * @param args
	 */
	public void attackMonser(WebSocket con, JSONArray args) {
		
	}
	public void getMonster(WebSocket con, JSONArray args) {
		
	}
}
