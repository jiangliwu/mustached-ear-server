package me.jiangliwu.EARServer.command;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;



import me.jiangliwu.EARServer.npc.NpcService;
import me.jiangliwu.EARServer.task.TaskService;
import me.jiangliwu.EARServer.user.UserServices;

import org.apache.log4j.Logger;
import org.java_websocket.WebSocket;
import org.json.JSONArray;
import org.json.JSONObject;

public class CommandParser {
	
	private static CommandParser m_instance= null;
	private static Logger log = Logger.getLogger(CommandParser.class);
	
	private Map<String,String> objectDict = null;
	private CommandParser (){}
	
	public boolean init(){
		objectDict = new HashMap<String,String>();
		objectDict.put("npc", NpcService.class.getName());
		objectDict.put("task", TaskService.class.getName());
		objectDict.put("user",UserServices.class.getName());
		return true;
	}
	public static CommandParser getInstance() {
		if (m_instance == null){
			m_instance = new CommandParser();
			m_instance.init();
		}
		
		return m_instance;
	}
	public  void parseCommand(WebSocket con , String msg){
		
		try {
			JSONObject json = new JSONObject(msg);
			try {
				
				String[] obj = json.getString("method").split("_");
				JSONArray array = json.getJSONArray("args");
				Class<?> o = Class.forName(objectDict.get(obj[0].toLowerCase()));
				o.getMethod(obj[1],WebSocket.class,JSONArray.class).invoke(o.newInstance(),con,array);
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
