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
import com.savan.model.Item;
import com.savan.utility.HibernateUtil;

/**
 * @author SAVAN
 *
 */
public class ManyToManyOne {
	
	public static void main(String[] args) {
		
		//setting data items
		Item iphone = new Item();
		iphone.setPrice(10);
		iphone.setDescription("very cheap");
		
		Item ipod = new Item();
		ipod.setPrice(100);
		ipod.setDescription("to Expencive");
		
		Set<Item> items = new HashSet<Item>();
		items.add(iphone);
		items.add(ipod);

		//setting data Cart
		Cart cart = new Cart();
		cart.setTotal(110);
		cart.setItems(items);
		
		//creating new cart as cart1 and item1
		Cart cart1 = new Cart();
		Set<Item> item1 = new HashSet<Item>();
		
		item1.add(iphone);
		cart1.setItems(item1);
		cart1.setTotal(10);
		
		
		//initializing SessionFactory
		SessionFactory factory = null;
		
		//initializing Session
		Session session = null;
		
		//initializing Transaction
		Transaction tx = null;
		
		
		try {
			
			//getting sessionFactroy from utility class
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			
			session.save(cart);
			session.save(cart1);
			
			tx.commit();
			session.close();
			
			System.out.println("Cart Id :"+cart.getId());
			System.out.println("Cart1 Id :"+cart1.getId());
			System.out.println("Item1 Id :"+iphone.getId());
			System.out.println("Item2 Id :"+ipod.getId());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (factory != null && !factory.isClosed()) {
				factory.close();
			}
		}
		
	}

}
