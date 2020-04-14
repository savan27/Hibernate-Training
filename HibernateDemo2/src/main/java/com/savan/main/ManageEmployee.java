/**
 * 
 */
package com.savan.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.savan.model.EmployeeDetail;

/**
 * @author SAVAN
 *
 */
public class ManageEmployee {
	
	private static SessionFactory factory; 
	
	public static void main(String[] args) {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		//create object
		ManageEmployee ME = new ManageEmployee();
		
		
		ME.addEmployee("abc", "xyz");
		ME.addEmployee("asd", "fgh");
		ME.addEmployee("qwe", "rty");
		
	}
	
	public Integer addEmployee(String fname, String lname) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();
			EmployeeDetail employee = new EmployeeDetail(fname, lname);
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {	
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

}
