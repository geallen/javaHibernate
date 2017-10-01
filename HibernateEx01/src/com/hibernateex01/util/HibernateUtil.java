package com.hibernateex01.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

	private static SessionFactory sessionFactoryObj = buildSessionFactoryObj();

	// Create The SessionFactory Object From Standard (Hibernate.cfg.xml) Configuration File
	//@SuppressWarnings("deprecation")
	public static SessionFactory buildSessionFactoryObj() {
		try {
			Configuration conf = new Configuration();
			conf.configure();
			ServiceRegistry serviceReg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
			sessionFactoryObj = conf.buildSessionFactory(serviceReg);
			
		} catch (ExceptionInInitializerError exceptionObj) {
			exceptionObj.printStackTrace();
		}
		return sessionFactoryObj;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactoryObj;
	}
}