package com.savan.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.savan.moel.Address;
import com.savan.moel.Employe;
import com.savan.utility.HibernateUtil;

/**
 * @author SAVAN
 *
 */
public class CriteriaCRUD {
	
	public static void main(String[] args) {
		
		// initialize session and transaction
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//creating CriteriaBuilder for criteria creation
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		System.out.println("-------------------------Select Query-------------------------");
		
		//select query 
		CriteriaQuery<Employe> cr = builder.createQuery(Employe.class);
		Root<Employe> root = cr.from(Employe.class);
		cr.select(root);
		
		//query creation 
		Query<Employe> q = session.createQuery(cr);
		
		//print the output
		printList(q);
		
		System.out.println("-------------------------Update Query-------------------------");
		
		CriteriaUpdate<Employe> update = builder.createCriteriaUpdate(Employe.class);
		Root<Employe> root1 = update.from(Employe.class);
		
		update.set(root1.get("salary"), 150);
		update.where(builder.equal(root1.get("name"), "David"));
		
		int i = session.createQuery(update).executeUpdate();
		
		System.out.println("Update Count :"+i);
		
		System.out.println("-------------------------Delete Query-------------------------");
		
		CriteriaDelete<Employe> delete = builder.createCriteriaDelete(Employe.class);	
		Root<Employe> root2 = delete.from(Employe.class);
		
		delete.where(builder.greaterThan(root2.<Integer>get("salary"), 400));
		
		int ans = session.createQuery(delete).executeUpdate();
		
		System.out.println("Update count of delete :"+ans);
		
		System.out.println("-------------------------Where Cluse (like)-------------------------");
		
		CriteriaQuery<Employe> cr1 = builder.createQuery(Employe.class);
		Root<Employe> root3 = cr1.from(Employe.class);
		
		cr1.select(root3).where(builder.like(root3.<String>get("name"), "%Dav%"));
		
		//query creation 
		Query<Employe> q1 = session.createQuery(cr1);
		
		//print the output
		printList(q1);
		
		System.out.println("-------------------------JOIN-------------------------");
		
		CriteriaQuery<Employe> cr2 = builder.createQuery(Employe.class);
		Root<Employe> root4 = cr2.from(Employe.class);
		root4.join("address");
		
		cr2.where(builder.isNotNull(root4.get("name")));
		
		//query creation 
		Query<Employe> q2 = session.createQuery(cr2);
		
		//print the output
		List<Employe> list = q2.getResultList();
		
		for (Employe employe : list) {
			System.out.println("Employe Id      :"+employe.getId());
			System.out.println("Employe name    :"+employe.getName());
			System.out.println("Employe salary  :"+employe.getSalary());
			Address add = employe.getAddress();
			System.out.println("Employe Address :"+add.getAddressLine1());
			System.out.println("Employe cirt    :"+add.getCity());
			System.out.println("Employe zipcode :"+add.getZipcode());
		}

		System.out.println("-------------------------Single Result-------------------------");
		
		CriteriaQuery<Employe> cr3 = builder.createQuery(Employe.class);
		Root<Employe> root5 = cr3.from(Employe.class);
		
		cr3.select(root5);
		cr3.where(builder.greaterThan(root5.<Integer>get("salary"), 200));
		
		//query creation 
		Query<Employe> q3 = session.createQuery(cr3);
		q3.setMaxResults(1);

		Employe list3 = q3.uniqueResult();
		
		System.out.println("EMployee Name :"+list3.getName());
		
		System.out.println("-------------------------OrderBy-------------------------");
		
		//select query 
		CriteriaQuery<Employe> cr4 = builder.createQuery(Employe.class);
		Root<Employe> root6 = cr4.from(Employe.class);
		
		cr4.orderBy(builder.asc(root6.get("name")));
		
		//query creation 
		Query<Employe> q4 = session.createQuery(cr4);
		
		//print the output
		List<Employe> list4 = q4.getResultList();
		
		for (Employe employe : list4) {
			
			System.out.println(employe.toString());
		}
		
		
		// commit to save the test data
		tx.commit();

		// closing Hibernate resources
		sessionFactory.close();
	}
	
	// utility method to execute query and print the output
	private static void printList(Query<Employe> q) {

		List<Employe> list = q.getResultList();

		for (Employe employe : list) {
			System.out.println("Employee Id     : " + employe.getId());
			System.out.println("Employee name   : " + employe.getName());
			System.out.println("Employee Salary : " + employe.getSalary());
		}
	}
	

}
