/**
 * 
 */
package com.savan.main;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.savan.moel.Employe;
import com.savan.utility.HibernateUtil;

/**
 * @author SAVAN
 *
 */
public class NamedQuery {
	
	public static void main(String[] args) {
		
		// initialize session and transaction
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//select Employee
		List<Employe> list = session.getNamedQuery("GET_ALL_EMPLOYE").list();
		
		for (Employe emp : list) {
			System.out.println("List of Employees::" + emp.getId() + ","
					+ emp.getAddress().getCity());
		}
	}
}
