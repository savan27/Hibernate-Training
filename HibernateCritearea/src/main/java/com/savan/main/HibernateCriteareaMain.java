/**
 * 
 */
package com.savan.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.savan.moel.Employee;
import com.savan.utility.HibernateUtil;

/**
 * @author SAVAN
 *
 */
public class HibernateCriteareaMain {
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		
		// Prep work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// HQL example - Get All Employees
		Query<Employee> query = session.createQuery("from Employe");
		List<Employee> empList = query.list();
		for(Employee emp:empList){
			System.out.println("List of Employees::" + emp.getId() + "," + emp.getAddress().getCity());
		}

		// HQL example - Get Employee with id
		query = session.createQuery("from Employe where emp_id= :id");
		query.setLong("id", 3);
		Employee emp = (Employee) query.uniqueResult();
		System.out.println("Employee Name=" + emp.getName() + ", City=" + emp.getAddress().getCity());
		
		// HQL Aggregate function examples
		String hql = "select sum(salary) from Employe";
		Query q = session.createQuery(hql);
		List results = q.list();
		System.out.println("result :"+results);
		
		// rolling back to save the test data
		tx.rollback();
		
		// closing hibernate resources
		sessionFactory.close();
	}

}
