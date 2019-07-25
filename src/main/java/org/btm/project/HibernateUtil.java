package org.btm.project;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	// 1st step to create a varriable to store the object 
	private static SessionFactory fatory;
	
	// 2nd to assign a object to the static varriable 
	static {
		Configuration configuration = new Configuration();
		configuration.configure("My.cfg.xml");
		fatory = configuration.buildSessionFactory();
	}
	// 3rd private constructor
	private  HibernateUtil() {
	
	}
	// 4th static public factory method
	public static SessionFactory getFactory() {
		return fatory;
	}
	
	
	
	
	

}
