package com.praveen.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.praveen.domain.Student;

@SuppressWarnings("serial")
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		   try {
			   /* hibernate configuration */
			Configuration configuration=new Configuration();
			configuration.addAnnotatedClass(Student.class);
			configuration.setProperties(new Properties() {
				{
					put("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
					put("hibernate.connection.url","jdbc:mysql://localhost:3306/hibernatedb");
					put("hibernate.connection.username","root");
					put("hibernate.connection.password","root");
					put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
					put("show_sql","true");
					put("hibernate.hbm2ddl.auto","update");
				}
			});
			StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		   } catch (Throwable th) {
			System.err.println("initial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		  }
		}
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	

}
