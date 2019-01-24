package com.praveen.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.praveen.domain.Student;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		   try {
			Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(Student.class);
			sessionFactory=configuration.buildSessionFactory(
					new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build());
		   } catch (Throwable th) {
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		  }
		}
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	

}
