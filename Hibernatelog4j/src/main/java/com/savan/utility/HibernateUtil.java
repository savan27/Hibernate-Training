/**
 * 
 */
package com.savan.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.savan.main.CriteriaCRUD;

/**
 * @author SAVAN
 *
 */
public class HibernateUtil {
	
private static SessionFactory factory;

private static final Logger logger = LogManager.getLogger(CriteriaCRUD.class);  
	
	//utility method to create sessionFactory 
	private static SessionFactory buiSessionFactory() {
		
		try {
			//Create the SessionFactory from hibernate.cfg.xml
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			logger.info("Hibernate Configuration loded");

			//creating SessinFactory
			SessionFactory factory = cfg.buildSessionFactory();
			
			return factory;
			
		} catch (Throwable ex) {
			logger.error("Initial SessionFactory creation failed." + ex);
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
