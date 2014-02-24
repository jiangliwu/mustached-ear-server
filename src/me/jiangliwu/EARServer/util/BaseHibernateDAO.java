package me.jiangliwu.EARServer.util;

import org.hibernate.Session;


public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return SessionFactoryHolder.getSession();
	}
	
}