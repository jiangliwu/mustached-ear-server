package me.jiangliwu.EARServer.npc;

import java.util.LinkedList;
import java.util.List;

import me.jiangliwu.EARServer.task.Task;
import me.jiangliwu.EARServer.user.User;
import me.jiangliwu.EARServer.util.DB;
import me.jiangliwu.EARServer.util.G;

import org.apache.log4j.Logger;
import org.java_websocket.WebSocket;
import org.json.JSONArray;
import org.json.JSONObject;

public class NpcService {

	private static Logger logger = Logger.getLogger(NpcService.class);

	
	public static void shareNpc(){
		for ( Object key : G.getInstance().getGame().keySet() ){
			
			List<Object> queryArgs = new LinkedList<Object>();
			queryArgs.add(key);
			List<?> npcList = DB.findByQuery("from " + Npc.class.getName()
					+ " as model where model.map.id" + "= ?", queryArgs);
			G.getInstance().getGame().get(key).put("npc", npcList);
		}
	}
	
	public void getNpcByMap(WebSocket con, JSONArray args) {

		try {
			Integer id = args.getInt(0);
			List<?> npcList = (List<?>) G.getInstance().getGame().get(id).get("npc");
			JSONObject ret = new JSONObject().put("method", "NPC_INIT");
			JSONArray npcs = new JSONArray();
			for (Object o : npcList) {
				npcs.put(((Npc) o).toJson());
			}
			ret.put("args", npcs);
			logger.debug(ret.toString());
			con.send(ret.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateTask(WebSocket con, JSONArray args) {
		List<Object> queryArgs = new LinkedList<Object>();
		queryArgs.add(User.getUser().getMap().getId());
		List<?> npcList = DB.findByQuery("from " + Npc.class.getName()
				+ " as model where model.map.id" + "= ?", queryArgs);

		for (Object o : npcList) {
			boolean needUpdate = false;
			Npc n = (Npc) o;
			for (Task i : n.getTasks()) {
				if (i.getFather() == null) {
					JSONObject ret = new JSONObject().put("method",
							"TASK_UPDATE");
					ret.put("args", i.toJson());
					con.send(ret.toString());
					break;
				}
			}
		}
	}
}
