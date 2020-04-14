package com.savan.Main;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.savan.Model.Address;
import com.savan.Model.EmployeeModel;
import com.savan.utility.HibernateUtil;

/**
 * @author SAVAN
 *
 */
public class EmployeeMain {
	
	
	//execution starts here
	public static void main(String[] args) {
		
		//initializing the sessionFactroy
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//session creation 
		Session session = factory.getCurrentSession();
		
		//transaction started
		Transaction tx = session.beginTransaction();
		
		EmployeeModel emp = new EmployeeModel();
		emp.setEmployeName("savan");
		emp.setEmail("sss@sss.ss");
		emp.setDoj(new Date());
		emp.setSalary(100000);
		
		EmployeeModel emp1 = new EmployeeModel();
		emp1.setEmployeName("savan vaishnav");
		emp1.setEmail("ss1@ss1.ss");
		emp1.setDoj(new Date());
		emp1.setSalary(100001);
		
		Address address1 = new Address();
		address1.setStreet("scince city road");
		address1.setCity("Ahmedabad");
		address1.setStste("Gujarat");
		address1.setCountry("India");
		
		Address address2 = new Address();
		address2.setStreet("vandematram febula");
		address2.setCity("Ahmedabad");
		address2.setStste("Gujarat");
		address2.setCountry("India");
		
		Address address3 = new Address();
		address3.setStreet("inexture Solution");
		address3.setCity("Ahmedabad");
		address3.setStste("Gujarat");
		address3.setCountry("India");
		
		emp.getAddress().add(address1);
		emp.getAddress().add(address2);
		emp.getAddress().add(address3);
		
		emp1.getAddress().add(address3);
		
		address1.getEmploye().add(emp);
		address2.getEmploye().add(emp);
		address3.getEmploye().add(emp);
		
		address3.getEmploye().add(emp1);
		
		
		int userId = (Integer) session.save(emp);
		int userId1 = (Integer) session.save(emp1);

		//committing transaction
		tx.commit();
		
		//closing session
		session.close();
		
	}
	
	

}
