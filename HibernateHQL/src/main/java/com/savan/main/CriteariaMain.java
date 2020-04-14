package com.savan.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.savan.moel.Employe;
import com.savan.utility.HibernateUtil;


/**
 * @author SAVAN
 *
 */
public class CriteariaMain {
	
	public static void main(String[] args) {
		
		// initialize session and transaction
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//creating CriteriaBuilder for criteria creation
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		System.out.println("-------------------------Select Query-------------------------");
		
		//select query 
			CriteriaQuery<Employe> criteria = builder.createQuery(Employe.class);
			Root<Employe> root = criteria.from(Employe.class);
			criteria.select(root);
			
			//query creation 
			Query<Employe> q1 = session.createQuery(criteria);
			
			//print the output
			printList(q1);
		
			System.out.println("-------------------------Where Cluse (equal)-------------------------");

		//where
			CriteriaQuery<Employe> criteria2 = builder.createQuery(Employe.class);
			Root<Employe> root2 = criteria2.from(Employe.class);
			criteria2.select(root2);
			criteria2.where(builder.equal(root2.get("name"), "Lisa"));
			
			//query creation 
			Query<Employe> q2 = session.createQuery(criteria2);
			
			//print the output
			printList(q2);
			
			System.out.println("-------------------------Where Cluse (gt)-------------------------");
			
			CriteriaQuery<Employe> cr = builder.createQuery(Employe.class);
			Root<Employe> root3 = cr.from(Employe.class);
			
			cr.select(root3);
			cr.where(builder.greaterThan(root3.<Integer>get("salary"), 200));
			
			//query creation 
			Query<Employe> q3 = session.createQuery(cr);
			
			//print the output
			printList(q3);
			
			System.out.println("-------------------------Where Cluse (like)-------------------------");
			
			CriteriaQuery<Employe> cr1 = builder.createQuery(Employe.class);
			Root<Employe> root4 = cr1.from(Employe.class);
			
			cr1.select(root4).where(builder.like(root4.<String>get("name"), "%Dav%"));
			
			//query creation 
			Query<Employe> q4 = session.createQuery(cr1);
			
			//print the output
			printList(q4);
			
			System.out.println("-------------------------Where Cluse (between)-------------------------");
			
			CriteriaQuery<Employe> cr2 = builder.createQuery(Employe.class);
			Root<Employe> root5 = cr2.from(Employe.class);
			
			cr2.select(root5).where(builder.between(root4.<Integer>get("salary"), 200, 400));
			
			//query creation 
			Query<Employe> q5 = session.createQuery(cr2);
			
			//print the output
			printList(q5);
			
			System.out.println("-------------------------Where Cluse (isNull)-------------------------");
			
			CriteriaQuery<Employe> cr3 = builder.createQuery(Employe.class);
			Root<Employe> root6 = cr3.from(Employe.class);
			
			cr3.select(root6).where(builder.isNull(root4.get("name")));
			
			//query creation 
			Query<Employe> q6 = session.createQuery(cr3);
			
			//print the output
			printList(q6);
			
			System.out.println("-------------------------Multiple Expression-------------------------");
			
			CriteriaQuery<Employe> cr4 = builder.createQuery(Employe.class);
			Root<Employe> root7 = cr4.from(Employe.class);
			
			Predicate[] predicates = new Predicate[2];
			predicates[0] = builder.isNotNull(root7.get("name"));
			predicates[1] = builder.like(root7.<String>get("name"), "%Jac%");
			
			
			cr4.select(root6).where(predicates);
			
			//query creation 
			Query<Employe> q7 = session.createQuery(cr4);
			
			//print the output
			printList(q7);
			
			System.out.println("-------------------------Aggrigate Function (avg)-------------------------");
			
			CriteriaQuery<Double> cr7 = builder.createQuery(Double.class);
			Root<Employe> root12 = cr7.from(Employe.class);
			
			cr7.select(builder.avg(root12.<Integer>get("salary")));
			
			//query creation 
			Query<Double> q10 = session.createQuery(cr7);
			
			//print the output
			List<Double> list = q10.getResultList();
			
			System.out.println("avg of salary : "+list);
			
			System.out.println("-------------------------Aggrigate Function (count)-------------------------");
			
			CriteriaQuery<Long> cr8 = builder.createQuery(Long.class);
			Root<Employe> root13 = cr8.from(Employe.class);
			
			cr8.select(builder.count(root13));
			
			//query creation 
			Query<Long> q11 = session.createQuery(cr8);
			
			//print the output
			List<Long> list1 = q11.getResultList();
			
			System.out.println("count of rows in table: "+list1);
			
									
			System.out.println("-------------------------Logical or-------------------------");
			
			CriteriaQuery<Employe> cr5 = builder.createQuery(Employe.class);
			Root<Employe> root8 = cr5.from(Employe.class);
			
			Predicate grater = builder.greaterThan(root8.<Integer>get("salary"), 200);
			Predicate like = builder.like(root8.<String>get("name"), "%Dav%");
			
			cr5.select(root8).where(builder.or(grater, like));
			
			//query creation 
			Query<Employe> q8 = session.createQuery(cr5);
			
			//print the output
			printList(q8);
			
			System.out.println("-------------------------Logical and-------------------------");
			
			CriteriaQuery<Employe> cr6 = builder.createQuery(Employe.class);
			Root<Employe> root9 = cr6.from(Employe.class);
			
			Predicate grater1 = builder.greaterThan(root9.<Integer>get("salary"), 100);
			Predicate like1 = builder.like(root9.<String>get("name"), "%Dav%");

			cr5.select(root9).where(builder.and(grater1, like1));
			
			//query creation 
			Query<Employe> q9 = session.createQuery(cr6);
			
			//print the output
			printList(q9);
						
			System.out.println("-------------------------runtime updateValue-------------------------");
			
			CriteriaUpdate<Employe> update = builder.createCriteriaUpdate(Employe.class);
			Root<Employe> root10 = update.from(Employe.class);
			
			update.set(root10.get("salary"), 150);
			update.where(builder.equal(root10.get("name"), "David"));
			
			int i = session.createQuery(update).executeUpdate();
			
			System.out.println("Update Count :"+i);
			
			System.out.println("-------------------------Criteria Delete-------------------------");
			
			CriteriaDelete<Employe> delete = builder.createCriteriaDelete(Employe.class);	
			Root<Employe> root11 = delete.from(Employe.class);
			
			delete.where(builder.greaterThan(root11.<Integer>get("salary"), 400));
			
			int ans = session.createQuery(delete).executeUpdate();
			
			System.out.println("Update count of delete :"+ans);
			
			
		// commit to save the test data
		tx.commit();

		// closing Hibernate resources
		sessionFactory.close();
		
	}

	//utility method to execute query and print the output
	private static void printList(Query<Employe> q) {

		List<Employe> list = q.getResultList();
		
		for (Employe employe : list) {
			System.out.println("Employee Id     : " + employe.getId() + "\t");
			System.out.println("Employee name   : " + employe.getName() + "\t");
			System.out.println("Employee Salary : " + employe.getSalary() + "\t");
		}

	}

}
