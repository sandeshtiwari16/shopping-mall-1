package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Shop;
import hibernatecfg.HibernateUtil;


public class ShopDao {
	
	//Save Student Details
	public void saveShop(Shop shop) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(shop);
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
	 
	public void updateShop(Shop shop) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(shop);
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
	public void deleteShop(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a shop object
			Shop shop = session.get(Shop.class, id);
			if (shop != null) {
				session.delete(shop);
				System.out.println("shop is deleted");
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
	public Shop getShop(int id) {

		Transaction transaction = null;
		Shop shop = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an shop object
			shop = session.get(Shop.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return shop;
	}
	
	//Display  ALL Student Details
	@SuppressWarnings("unchecked")
	public List<Shop> getAllShop() {

		Transaction transaction = null;
		List<Shop> listOfShop = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an shop object
			
			listOfShop = session.createQuery("from Shop").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfShop;
	}
}
