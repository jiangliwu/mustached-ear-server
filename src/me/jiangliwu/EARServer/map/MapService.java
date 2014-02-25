package me.jiangliwu.EARServer.map;

import java.util.List;

import me.jiangliwu.EARServer.util.DB;
import me.jiangliwu.EARServer.util.G;

public class MapService {
	
	public static void shareMap(){
		List<?> maps = DB.findAll(Map.class.getName());
		
		for( Object m : maps) {
			java.util.Map<Object, Object> mapData = new java.util.HashMap<>();
			mapData.put("map", m);
			G.getInstance().getGame().put(((Map)m).getId(), mapData);
		}
	}
}
