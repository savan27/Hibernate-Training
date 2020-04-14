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
		
		Address address = new Address();
		address.setStreet("scince city road");
		address.setCity("Ahmedabad");
		address.setStste("Gujarat");
		address.setCountry("India");
		
		emp.setAddress(address);
		
		int userId = (Integer) session.save(emp);
		
		if (userId > 0) {
			logger.info("user Added Successfully");
		}
		else {
			logger.error("faile to add user");
		}
		
		//committing transaction
		tx.commit();
		
		//closing session
		session.close();
		
	}
	
	

}
