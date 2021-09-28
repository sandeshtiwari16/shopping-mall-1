package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Owner;
import hibernatecfg.HibernateUtil;


public class OwnerDao {
	
	//Save Student Details
	public void saveOwner(Owner owner) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(owner);
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
	 
	public void updateOwner(Owner owner) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(owner);
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
	public void deleteOwner(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a owner object
			Owner owner = session.get(Owner.class, id);
			if (owner != null) {
				session.delete(owner);
				System.out.println("owner is deleted");
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
	public Owner getOwner(int id) {

		Transaction transaction = null;
		Owner owner = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an owner object
			owner = session.get(Owner.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return owner;
	}
	
	//Display  ALL Student Details
	@SuppressWarnings("unchecked")
	public List<Owner> getAllOwner() {

		Transaction transaction = null;
		List<Owner> listOfOwner = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an owner object
			
			listOfOwner = session.createQuery("from Owner").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfOwner;
	}
}
