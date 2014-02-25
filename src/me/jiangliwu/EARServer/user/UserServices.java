package me.jiangliwu.EARServer.user;



import java.util.List;

import me.jiangliwu.EARServer.npc.Npc;
import me.jiangliwu.EARServer.util.DB;
import me.jiangliwu.EARServer.util.G;

import org.java_websocket.WebSocket;
import org.json.JSONArray;
import org.json.JSONObject;

public class UserServices {

	public void login(WebSocket con, JSONArray args) {
		String username = args.getString(0);
		String password = args.getString(1);
		
		List users = DB.findByProperty(User.class.getName(), "name", username);
		if(users.size() == 0)
		{
			JSONObject ret = new JSONObject().put("method", "LOGIN_FAIL");
			con.send(ret.toString());
		}else{
			JSONObject ret = new JSONObject().put("method", "LOGIN_SUCCESS");
			User u = ((User)users.get(0));
			
			User.setUser(u);			// register global user record
			
			String [] pos = u.getPosition().split(";");
			JSONObject retArgs = new JSONObject().put("posx",Integer.parseInt(pos[0]))
					.put("posy", Integer.parseInt(pos[1])).put("map", u.getMap().getId());
			ret.put("args", retArgs);
			con.send(ret.toString());
			
			
		}
	}
}
