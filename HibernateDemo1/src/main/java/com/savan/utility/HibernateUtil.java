/**
 * 
 */
package com.savan.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author SAVAN
 */
public class HibernateUtil {
	
	//SessionFactory Configuration
	private static SessionFactory sf;
	
	private static SessionFactory buildSessionFactory() {
		
		try {
			
			//Create SessionFactory from hibernate.cfg.xml file
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			System.out.println("hibernate Configration loaded");
			
			ServiceRegistry serviceregistery = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			System.out.println("hibernate ServiceRegistery Created");
			
			SessionFactory sf = configuration.buildSessionFactory(serviceregistery);
			
			return sf;
		} 
		catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		
		if (sf == null) {
			sf = buildSessionFactory();
		}
		
		return sf;
	}
	
	

}
