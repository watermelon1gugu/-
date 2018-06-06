package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static Configuration cfg=null;
	private static SessionFactory sessionFactory=null;
	//静态代码块
	static {
		//加载核心配置文件
		 cfg=new Configuration();
		 cfg.configure();
	     sessionFactory=cfg.buildSessionFactory();		
	}
	
	//提供与本地线程绑定的session的方法
	public static Session getSessionobject() {
		return sessionFactory.getCurrentSession();
	}
	
	//提供方法返回sessionFactory
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		
	}
	
}
