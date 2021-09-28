package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Item;
import hibernatecfg.HibernateUtil;


public class ItemDao {
	
	//Save Student Details
	public void saveItem(Item item) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(item);
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
	 
	public void updateItem(Item item) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(item);
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
	public void deleteItem(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a item object
			Item item = session.get(Item.class, id);
			if (item != null) {
				session.delete(item);
				System.out.println("item is deleted");
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
	public Item getItem(int id) {

		Transaction transaction = null;
		Item item = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an item object
			item = session.get(Item.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return item;
	}
	
	//Display  ALL Student Details
	@SuppressWarnings("unchecked")
	public List<Item> getAllItem() {

		Transaction transaction = null;
		List<Item> listOfItem = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an item object
			
			listOfItem = session.createQuery("from Item").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfItem;
	}
}
