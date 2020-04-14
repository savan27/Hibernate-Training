/**
 * 
 */
package com.savan.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.LongType;

import com.savan.moel.Address;
import com.savan.moel.Employe;
import com.savan.utility.HibernateUtil;

/**
 * @author SAVAN
 *
 */
public class NativeSQLMain {
	
	public static void main(String[] args) {
		
		// initialize session and transaction
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//select employ data
		List<Employe> list = session.createNativeQuery("select * from Employe").addEntity(Employe.class).list();
		
		for (Employe objects : list) {
			System.out.println("id "+objects.getId());
			System.out.println("name "+objects.getName());
			System.out.println("salary "+objects.getSalary());
		}
		
		//scaler 
		
		List<Object []> list1 = session.createNativeQuery("select emp_id,emp_name from Employe").addScalar("emp_id",LongType.INSTANCE).addScalar("emp_name").list();
		
		for (Object[] objects : list1) {
			long id = (Long)objects[0];
			String name = (String)objects[1];
			System.out.println("id :"+id);
			System.out.println("name :"+name);
		}
		
		//join
		List<Object []> list2 = session.createNativeQuery("select * from Employe e JOIN Address a ON e.emp_id=a.emp_id").addEntity("emp",Employe.class).addJoin("add", "emp.address").list();
		
		for (Object[] objects : list2) {
			Employe e = (Employe) objects[0];
			System.out.println("Employee Id     ::"+e.getId());
			System.out.println("Employee name   ::"+e.getName());
			System.out.println("Employee salary ::"+e.getSalary());
			Address a = (Address) objects[1];
			System.out.println("Address Id   ::"+a.getId());
			System.out.println("AddressLine1 ::"+a.getAddressLine1());
			System.out.println("coty         ::"+a.getCity());
			System.out.println("Zipcode      ::"+a.getZipcode());
		}
		
		//add parameter
		List<Employe> list3 = session.createNativeQuery("select * from Employe where emp_name like :name").addEntity(Employe.class).setParameter("name", "%Dav%").list();
		
		for (Employe objects : list3) {
			System.out.println("------------------parameter query----------------");
			System.out.println("Employee Id     ::"+objects.getId());
			System.out.println("Employee name   ::"+objects.getName());
			System.out.println("Employee salary ::"+objects.getSalary());
		}
	}
	

}
