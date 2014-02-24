package me.jiangliwu.EARServer;

import static org.junit.Assert.*;
import me.jiangliwu.EARServer.map.Map;
import me.jiangliwu.EARServer.npc.Npc;
import me.jiangliwu.EARServer.task.Task;
import me.jiangliwu.EARServer.user.User;

import org.junit.Test;

public class ModelsTest {

	@Test
	public void test() {
		// fail("Not yet implemented");
		
		Map m = new Map();
		
		User u = new User();

		u.setName("vv-jiangliwu1");
		u.setMap(m);
		u.setPosition("1;20");
		u.save();
		
		
		
		Npc n = new Npc();
		n.setMap(m);
		n.setPosx(5);
		n.setPosy(16);
		n.setMessage("hello , world !");
		
		
		Task t = new Task();
		t.setContent("find star");
		t.setTaskExp(100);
		t.setTitle("hello");
		t.setNpc(n);
		t.save();
		
		n.getTasks().add(t);
		u.getTasks().add(t);
		
		n.save();
		u.save();

		
	}

}
