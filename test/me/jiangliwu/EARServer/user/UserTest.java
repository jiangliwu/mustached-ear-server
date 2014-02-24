package me.jiangliwu.EARServer.user;

import static org.junit.Assert.*;
import me.jiangliwu.EARServer.task.Task;

import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		User u = new User();
		
		u.setName("vv-jiangliwu1");
		u.setMap(new me.jiangliwu.EARServer.map.Map());
		u.setPosition("1;20");
		
		Task t = new Task();
		t.setContent("find star");
		t.setTaskExp(100);
		t.setTitle("hello");
		u.getTasks().add(t);
		
		u.save();
	}

}
