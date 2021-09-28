package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Employee;
import hibernatecfg.HibernateUtil;


public class EmployeeDao {
	
	//Save Student Details
	public void saveEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(employee);
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
	 
	public void updateEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(employee);
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
	public void deleteEmployee(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a employee object
			Employee employee = session.get(Employee.class, id);
			if (employee != null) {
				session.delete(employee);
				System.out.println("employee is deleted");
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
	public Employee getEmployee(int id) {

		Transaction transaction = null;
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an employee object
			employee = session.get(Employee.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employee;
	}
	
	//Display  ALL Student Details
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {

		Transaction transaction = null;
		List<Employee> listOfEmployee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an employee object
			
			listOfEmployee = session.createQuery("from Employee").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfEmployee;
	}
}
