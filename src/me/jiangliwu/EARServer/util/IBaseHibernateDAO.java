package me.jiangliwu.EARServer.util;
import org.hibernate.Session;



public interface IBaseHibernateDAO {
	public Session getSession();
}