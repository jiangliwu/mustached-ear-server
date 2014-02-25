package me.jiangliwu.EARServer.util;

import java.util.HashMap;
import java.util.Map;

public class G {
	
	private static G instance = null;
	
	private Map<Object,Map<Object,Object>> game;
	private Map<Object,Object> users;
	
	private G(){
		setGame(new HashMap<Object, Map<Object,Object>>());
	}
	
	public static G getInstance(){
		if ( instance == null)
			instance = new G();
		return instance;
	}

	public Map<Object,Map<Object,Object>> getGame() {
		return game;
	}

	public void setGame(Map<Object,Map<Object,Object>> game) {
		this.game = game;
	}

	public Map<Object,Object> getUsers() {
		return users;
	}

	public void setUsers(Map<Object,Object> users) {
		this.users = users;
	}



}
