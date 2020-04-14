/**
 * 
 */
package com.savan.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author SAVAN
 *
 */
public class HibernateUtil {
	
private static SessionFactory factory;
	
	//utility method to create sessionFactory 
	private static SessionFactory buiSessionFactory() {
		
		try {
			//Create the SessionFactory from hibernate.cfg.xml
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			System.out.println("Hibernate Configuration loded");

			//creating SessinFactory
			SessionFactory factory = cfg.buildSessionFactory();
			
			return factory;
			
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
		}
		
	}
	
	//public method to get sessonFactory
	public static SessionFactory getSessionFactory() {

		//create if not available
		if (factory == null) {
			factory = buiSessionFactory();
		}
		
		return factory;
	}

}
