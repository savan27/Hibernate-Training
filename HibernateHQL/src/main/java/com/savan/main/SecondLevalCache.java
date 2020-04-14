/**
 * 
 */
package com.savan.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.savan.utility.HibernateUtil;

/**
 * @author SAVAN
 *
 */
public class SecondLevalCache {
	
	public static void main(String[] args) {
		
		// initialize session and transaction
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		
		
	}

}
