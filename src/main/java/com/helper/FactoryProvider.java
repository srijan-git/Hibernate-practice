package com.helper;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class FactoryProvider {

	public static SessionFactory factory;

	public static SessionFactory getFactory() {
		
		if(factory==null) {
			factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		
		return factory;
	}
	
	public void closeFactory() {
		if(factory.isOpen()) {
			factory.close();
		}
	}
}
