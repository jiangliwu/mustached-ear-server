package me.jiangliwu.EARServer.util;

import static org.junit.Assert.*;

import java.util.List;

import me.jiangliwu.EARServer.user.User;

import org.junit.AfterClass;
import org.junit.Test;

public class DBTest2 {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		
		User u = (User)DB.findByID(User.class.getName(), 2);
		System.out.println(u.getName());
		
		List<?> list = DB.findByProperty(User.class.getName(),"lvl", 2);
		for ( Object o : list){
			u = (User)o;
			System.out.println(u.getName());
		}
	}

}
