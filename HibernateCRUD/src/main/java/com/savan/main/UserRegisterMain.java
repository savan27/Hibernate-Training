/**
 * 
 */
package com.savan.main;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.savan.model.UserModel;

/**
 * @author SAVAN
 *
 */
public class UserRegisterMain {
	
	private static final Logger logger = LogManager.getLogger(UserRegisterMain.class); 
	
	//initialize session
	private static Session session; 
	
	//initialize Transaction
	private static Transaction tx = null;
	
	//execution starts here
	public static void main(String[] args) {
		
		//create UserRegisterMain Object
		UserRegisterMain u = new UserRegisterMain();
		
		Integer userId1 = u.registerUser("Zara", "Ali");
	    Integer userId2 = u.registerUser("Daisy", "Das");
	    Integer userId3 = u.registerUser("John", "Paul");
	    
	    logger.info("success...");
	    
	    //list all user
		 u.listuser(); 
		
		//update user Name
		 u.updateUser(userId1,"opop"); 
	    
	    //delete user
	    u.deleteUser(2);
	}
	
	//utility method to delete user
	private void deleteUser(int userId) {
		
		try {
			//initialize session
			initSession();
			
			UserModel u = session.get(UserModel.class, userId);
			logger.info("success...");
			//update 
			session.delete(u);
			
		} 
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			
			//close session
			closeSession();
		}
		
	}

	//utility method to update user 
	private void updateUser(int userId,String name) {

		try {
			//initialize session
			initSession();
			
			UserModel u = session.get(UserModel.class, userId);
			u.setFirstname(name);
			
			//update 
			session.update(u);
			
		} 
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			
			//close session
			closeSession();
		}
		
	}

	//utility method to read all user
	private void listuser() {

		try {
			//initialize session
			initSession();
			
			List user = session.createQuery("FROM UserModel").list();
			
			for (Iterator iterator = user.iterator(); iterator.hasNext();) {
				UserModel u = (UserModel) iterator.next();
				
				System.out.println("User Id : " + u.getId());
				System.out.println("First Name : " + u.getFirstname());
				System.out.println("Last Name : " + u.getLastname());
				System.out.println("");
			}
		} 
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			
			//close session
			closeSession();
		}
		
	}

	//utility method to insert user
	private Integer registerUser(String firstname, String lastname) {
		
		//initialize userId
		Integer userid = null;
		
		try {
			//initialize session
			initSession();
			
			//create user Object
			UserModel u = new UserModel(firstname, lastname);
			userid =  (Integer) session.save(u);
		} 
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			
			//close session
			closeSession();
		}
		
		return userid;
	}
	
	//utility method to start session
	private static void initSession() {
		
		//create SesionFactory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();	
		
		//creating session 
		session = factory.openSession();
		tx = session.beginTransaction();
	}
	
	//utility method to close session 
	private static void closeSession() {
		
		//commit transaction and close session
		tx.commit();
		session.close();
	}
}
