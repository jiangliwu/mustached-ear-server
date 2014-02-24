package me.jiangliwu.EARServer;

import static org.junit.Assert.*;
import me.jiangliwu.EARServer.map.Map;
import me.jiangliwu.EARServer.npc.Npc;
import me.jiangliwu.EARServer.task.Task;
import me.jiangliwu.EARServer.user.User;
import me.jiangliwu.EARServer.util.DB;

import org.junit.Test;

public class ModelsTest2 {

	public Task getTask(Task father , Npc npc , int id){
		Task t = new Task();
		
		t.setContent("find star on earth");
		t.setFather(father);
		t.setNpc(npc);
		t.setTitle("find some thing " + id);
		
		return t;
	}
	@Test
	public void test() {
		//fail("Not yet implemented");
		
		//Map m = (Map)DB.findByID(Map.class.getName(), 1);
		
		Map m = new Map();
		
		Npc n1 = new Npc();
		n1.setMap(m);
		n1.setPosx(5);
		n1.setPosy(16);
		n1.setMessage("我是Npc1~~~,请问找我何事!");
		n1.setName("npc-1");
		
		
		Npc n2 = new Npc();
		n2.setMap(m);
		n2.setPosx(5);
		n2.setPosy(16);
		n2.setMessage("我是Npc2~~~,请问找我何事!");
		n2.setName("npc-2");
		
		Task t1 = getTask(null,n1,1);
		Task t2 = getTask(t1,n1,2);
		Task t3 = getTask(t2,n1,3);
		Task t4 = getTask(t3,n2,3);
		
		n1.getTasks().add(t1);
		n1.getTasks().add(t2);
		n1.getTasks().add(t3);
		n1.save();
		
		n2.getTasks().add(t4);
		n2.save();
		
		
		User u = new User();
		u.setName("vv-jiangliwu1");
		u.setMap(m);
		u.setPosition("0;19");
		u.save();
	}

}
