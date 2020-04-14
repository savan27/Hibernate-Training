/**
 * 
 */
package com.savan.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.savan.model.Cart;
import com.savan.model.Items;
import com.savan.utility.HibernateUtil;

/**
 * @author SAVAN
 *
 */
public class OneToManyMain {
	
		//initialize sessionFactory
		private static SessionFactory factory;
		
		//initialize session
		private static Session session;
		
		//initialize Transaction
		private static Transaction tx;
	
		//execution Starts here
		public static void main(String[] args) {
			
			Cart cart = new Cart();
			cart.setName("My Cart");
			
			Items item1 = new Items("I1", 10, 1, cart);
			Items item2 = new Items("I2", 20, 2, cart);	
			
			Set<Items> itemsSet = new HashSet<Items>();
			itemsSet.add(item1);
			itemsSet.add(item2);
			
			cart.setItems(itemsSet);
			cart.setTotal(10*1 + 20*2);
			
			try {
				//get sessionFactory
				factory = HibernateUtil.getSessionFactory();
				
				//get session
				session = factory.getCurrentSession();
				System.out.println("session Created");
				
				//start Transaction 
				tx = session.beginTransaction();
				
				//save the model object
				session.save(cart);
				session.save(item1);
				session.save(item2);
				
				//commit transaction
				tx.commit();
				
				System.out.println("Cart ID="+cart.getId());
			} 
			catch(Exception e){
				System.out.println("Exception occured. "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				if(!factory.isClosed()){
					System.out.println("Closing SessionFactory");
					factory.close();
				}
			}
		}

}
