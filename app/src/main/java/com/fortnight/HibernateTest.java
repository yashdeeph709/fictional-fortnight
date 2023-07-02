package com.fortnight;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fortnight.util.HibernateUtil;


public class HibernateTest {
	public static void main(String args[]) {
	        Transaction transaction = null;
			/*Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
	        Student student1 = new Student("John", "Cena", "john@javaguides.com");
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student objects
	            session.persist(student);
	            session.persist(student1);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }*/

	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            List<Student> students = session.createQuery("from Student", Student.class).list();
	            students.forEach(s -> System.out.println(s.getFirstName()));
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	}
}
