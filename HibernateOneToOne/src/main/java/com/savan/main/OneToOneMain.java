/**
 * 
 */
package com.savan.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.savan.model.Customer;
import com.savan.model.Txn;
import com.savan.util.HibernateUtil;

/**
 * @author SAVAN
 *
 */
public class OneToOneMain {
	
	//initialize sessionFactory
	private static SessionFactory factory;
	
	//initialize session
	private static Session session;
	
	//initialize Transaction
	private static Transaction tx;
	
	//program execution starts here
	public static void main(String[] args) {
		
		//create transaction
		Txn txn = buildTeansection();
		
		try {
			
			//get sessionFactory
			factory = HibernateUtil.getSessionFactory();
			
			//get session
			session = factory.getCurrentSession();
			System.out.println("session Created");
			
			//start Transaction 
			tx = session.beginTransaction();
			
			//save the model object
			session.save(txn);
			
			//commit transaction
			tx.commit();
			
			System.out.println("Transaction ID="+txn.getId());
			
			//print transaction details
			printDetail(txn.getId(),factory);
			
		} 
		catch (Exception e) {
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!factory.isClosed()){
				System.out.println("Closing SessionFactory");
				factory.close();
			}
		}
			
	}

	//utility method to print transaction
	private static void printDetail(long id, SessionFactory factory2) {

		try {
			
			//get sessionFactory
			factory = HibernateUtil.getSessionFactory();
			
			//get session
			session = factory.getCurrentSession();
			System.out.println("session Created");
			
			//start Transaction 
			tx = session.beginTransaction();
			
			//save the model object
			Txn txn = session.get(Txn.class, id);
			
			//commit transaction
			tx.commit();
			System.out.println("Transaction Details=\n"+txn);
			
		} 
		catch (Exception e) {
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}
		
	}

	//utility method to create transaction
	private static Txn buildTeansection() {

		Txn txn = new Txn();
		txn.setTotal(100);
		txn.setDate(new Date());
		
		//embeddable type data
		Customer cust = new Customer();
		cust.setName("savan1");
		cust.setEmail("savan@savan.savan");
		cust.setAddress("india");
		
		txn.setCustomer(cust);
		
		cust.setTxn(txn);
		
		//return transaction
		return txn;
	}

}
