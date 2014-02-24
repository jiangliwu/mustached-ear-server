package me.jiangliwu.EARServer.util;

import static org.junit.Assert.*;
import me.jiangliwu.EARServer.user.User;

import org.junit.AfterClass;
import org.junit.Test;

public class SessionFactoryHolderTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		SessionFactoryHolder.getSession().beginTransaction();
		User u = new User();
		u.setName("Jiangliwu");
		SessionFactoryHolder.getSession().save(u);
		SessionFactoryHolder.getSession().getTransaction().commit();
		
		System.out.println(SessionFactoryHolderTest.class.getName());
		
	}

}
