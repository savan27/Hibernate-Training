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
	
	//initializing logger 
	private static final Logger logger = LogManager.getLogger(EmployeeMain.class);
	
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
		
		Address address1 = new Address();
		address1.setStreet("scince city road");
		address1.setCity("Ahmedabad");
		address1.setStste("Gujarat");
		address1.setCountry("India");
		address1.setEmploye(emp);
		
		Address address2 = new Address();
		address2.setStreet("vandematram febula");
		address2.setCity("Ahmedabad");
		address2.setStste("Gujarat");
		address2.setCountry("India");
		address2.setEmploye(emp);
		
		emp.getAddress().add(address1);
		emp.getAddress().add(address2);
		
		int userId = (Integer) session.save(emp);

		//committing transaction
		tx.commit();
		
		//closing session
		session.close();
		
	}
	
	

}
