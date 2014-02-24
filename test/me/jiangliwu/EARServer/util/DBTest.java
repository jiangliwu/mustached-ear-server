package me.jiangliwu.EARServer.util;

import static org.junit.Assert.*;
import me.jiangliwu.EARServer.user.User;

import org.junit.AfterClass;
import org.junit.Test;

public class DBTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		
		
		User u = new User();
		u.setName("vv-jiangliwu");
		
		DB.save(u);
		DB.delete(u);
		
		User u1 = new User();
		u1.setName("vv-jiangliwu1");
		u1.setLvl(2);
		DB.save(u1);
		
		User u2 = new User();
		u2.setName("vv-jiangliwu2");
		u2.setLvl(2);
		DB.save(u2);
		
		User u3 = new User();
		u3.setName("vv-jiangliwu3");
		u3.setLvl(2);
		DB.save(u3);
		
		
		User u4 = new User();
		u4.setName("vv-jiangliwu4");
		u4.setLvl(3);
		DB.save(u4);
	}

}
