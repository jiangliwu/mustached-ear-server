package me.jiangliwu.EARServer.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class DB {
	
	private static final Logger log = Logger.getLogger(DB.class);
	
	public static void save(Object o){
		log.debug(o.getClass().getName() + " start save " + o);
		Session session = SessionFactoryHolder.getSession();
		try {
			session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
			log.debug(o.getClass().getName() + " save success " + o);
		} catch (Exception ex) {
			log.debug(o.getClass().getName() + " save error ! " + o);
			ex.printStackTrace();
		}
	}
	
	public static void delete(Object o) {
		log.debug(o.getClass().getName() + " start delete " + o);
		Session session = SessionFactoryHolder.getSession();
		try {
			session.beginTransaction();
			session.delete(o);
			session.getTransaction().commit();
			log.debug(o.getClass().getName() + " delete success " + o);
		} catch (Exception ex) {
			log.debug(o.getClass().getName() + " delete error " + o);
		}
	}
	
	public static Object findByID(String className ,int id){
		log.debug(className + " find id = " + id );
		try {
			return SessionFactoryHolder.getSession().get(
					className, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static List<?> findByQuery(String sql,List<Object> args){
		log.debug("query = " + sql);
		try {
			Query queryObject = SessionFactoryHolder.getSession().createQuery(
					sql);
			int i = 0;
			for(Object o : args){
				queryObject.setParameter(i++,o);
			}
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("----------- " + sql, re);
			throw re;
		}
	}
	public static List<?> findByProperty(String className , String propertyName, Object value){
		
		log.debug("finding "+ className + " instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from "+ className +" as model where model."
					+ propertyName + "= ?";
			Query queryObject = SessionFactoryHolder.getSession().createQuery(
					queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}
