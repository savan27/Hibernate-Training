/**
 * 
 */
package com.savan.main;

import org.hibernate.Session;

import com.savan.model.Userdetail;
import com.savan.utility.HibernateUtil;

/**
 * @author SAVAN
 *
 */
public class UserdetailMain {
	
	public static void main(String[] args) {
		
		Userdetail u = new Userdetail();
		u.setFirstname("savan");
		u.setLastname("vaishnav");
		
		//get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		//start Transaction
		session.beginTransaction();
		
		//save the model object
		session.save(u);
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("Employee Id :"+u.getId());
		
		//terminate the SessionFactory to stop program Execution
		HibernateUtil.getSessionFactory().close();
		
	}

}
