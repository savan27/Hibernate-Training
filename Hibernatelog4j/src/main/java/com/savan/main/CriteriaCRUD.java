package com.savan.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.savan.model.Address;
import com.savan.model.Employe;
import com.savan.utility.HibernateUtil;

/**
 * @author SAVAN
 *
 */
public class CriteriaCRUD {
	
	private static final Logger logger = LogManager.getLogger(CriteriaCRUD.class);  
	
	public static void main(String[] args) {
		
		try {
			// initialize session and transaction
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			
			//creating CriteriaBuilder for criteria creation
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			logger.info("-------------------------Select Query-------------------------");
			
			//select query 
			CriteriaQuery<Employe> cr = builder.createQuery(Employe.class);
			Root<Employe> root = cr.from(Employe.class);
			cr.select(root);
			
			//query creation 
			Query<Employe> q = session.createQuery(cr);
			
			//print the output
			printList(q);
			
			logger.info("-------------------------Update Query-------------------------");
			
			CriteriaUpdate<Employe> update = builder.createCriteriaUpdate(Employe.class);
			Root<Employe> root1 = update.from(Employe.class);
			
			update.set(root1.get("salary"), 150);
			update.where(builder.equal(root1.get("name"), "David"));
			
			int i = session.createQuery(update).executeUpdate();
			
			logger.info("Update Count :"+i);
			
			logger.info("-------------------------Delete Query-------------------------");
			
			CriteriaDelete<Employe> delete = builder.createCriteriaDelete(Employe.class);	
			Root<Employe> root2 = delete.from(Employe.class);
			
			delete.where(builder.greaterThan(root2.<Integer>get("salary"), 400));
			
			int ans = session.createQuery(delete).executeUpdate();
			
			logger.info("Update count of delete :"+ans);
			
			logger.info("-------------------------Where Cluse (like)-------------------------");
			
			CriteriaQuery<Employe> cr1 = builder.createQuery(Employe.class);
			Root<Employe> root3 = cr1.from(Employe.class);
			
			cr1.select(root3).where(builder.like(root3.<String>get("name"), "%Dav%"));
			
			//query creation 
			Query<Employe> q1 = session.createQuery(cr1);
			
			//print the output
			printList(q1);
			
			logger.info("-------------------------JOIN-------------------------");
			
			CriteriaQuery<Employe> cr2 = builder.createQuery(Employe.class);
			Root<Employe> root4 = cr2.from(Employe.class);
			root4.join("address");
			
			cr2.where(builder.isNotNull(root4.get("name")));
			
			//query creation 
			Query<Employe> q2 = session.createQuery(cr2);
			
			//print the output
			List<Employe> list = q2.getResultList();
			
			for (Employe employe : list) {
				logger.info("Employe Id      :"+employe.getId());
				logger.info("Employe name    :"+employe.getName());
				logger.info("Employe salary  :"+employe.getSalary());
				Address add = employe.getAddress();
				logger.info("Employe Address :"+add.getAddressLine1());
				logger.info("Employe cirt    :"+add.getCity());
				logger.info("Employe zipcode :"+add.getZipcode());
			}

			logger.info("-------------------------Single Result-------------------------");
			
			CriteriaQuery<Employe> cr3 = builder.createQuery(Employe.class);
			Root<Employe> root5 = cr3.from(Employe.class);
			
			cr3.select(root5);
			cr3.where(builder.greaterThan(root5.<Integer>get("salary"), 200));
			
			//query creation 
			Query<Employe> q3 = session.createQuery(cr3);
			q3.setMaxResults(1);

			Employe list3 = q3.uniqueResult();
			
			logger.info("EMployee Name :"+list3.getName());
			
			logger.info("-------------------------OrderBy-------------------------");
			
			//select query 
			CriteriaQuery<Employe> cr4 = builder.createQuery(Employe.class);
			Root<Employe> root6 = cr4.from(Employe.class);
			
			cr4.orderBy(builder.asc(root6.get("name")));
			
			//query creation 
			Query<Employe> q4 = session.createQuery(cr4);
			
			//print the output
			List<Employe> list4 = q4.getResultList();
			
			for (Employe employe : list4) {
				
				logger.info(employe.toString());
			}
			
			
			// commit to save the test data
			tx.commit();

			// closing Hibernate resources
			sessionFactory.close();
			
			logger.info("Success....");
			logger.info("Success....again....");
			
		} catch (HibernateException e) {
			logger.error("Fail : "+e);
			e.printStackTrace();
		}
	}
	
	// utility method to execute query and print the output
	private static void printList(Query<Employe> q) {

		List<Employe> list = q.getResultList();

		for (Employe employe : list) {
			logger.info("Employee Id     : " + employe.getId());
			logger.info("Employee name   : " + employe.getName());
			logger.info("Employee Salary : " + employe.getSalary());
		}
	}
	

}
