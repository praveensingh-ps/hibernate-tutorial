package com.praveen.test;

import org.hibernate.Session;

import com.praveen.domain.Student;
import com.praveen.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionfactory().openSession();
		Student stu=new Student();
		stu.setRollNo(100);
		stu.setName("praveen");
		session.beginTransaction();
		session.save(stu);
		session.getTransaction().commit();

	}

}
