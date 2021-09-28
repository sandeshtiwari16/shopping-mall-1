package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Mall;
import hibernatecfg.HibernateUtil;


public class MallDao {
	
	//Save Student Details
	public void saveMall(Mall mall) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(mall);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	//Update Student Details
	 
	public void updateMall(Mall mall) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(mall);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	//Delete Student Details
	public void deleteMall(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a mall object
			Mall mall = session.get(Mall.class, id);
			if (mall != null) {
				session.delete(mall);
				System.out.println("mall is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	//Display  Specific Student Details
	public Mall getMall(int id) {

		Transaction transaction = null;
		Mall mall = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an mall object
			mall = session.get(Mall.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return mall;
	}
	
	//Display  ALL Student Details
	@SuppressWarnings("unchecked")
	public List<Mall> getAllMall() {

		Transaction transaction = null;
		List<Mall> listOfMall = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an mall object
			
			listOfMall = session.createQuery("from Mall").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfMall;
	}
}
