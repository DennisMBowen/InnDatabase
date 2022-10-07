package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Customer;
import model.HotelRoom;

/**
 * @author Dennis Bowen - dmbowen
 * CIS175 - Fall 2022
 * Oct 4, 2022
 */
public class CustomerHelper {
	
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InnDatabase");
	
	//Method to accept a Customer to add
	public void insertCustomer (Customer c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
			
	public List<Customer> showAllCustomers(){
		EntityManager em = emfactory.createEntityManager();
		List<Customer>allCustomers = em.createQuery("SELECT i FROM Customer i").getResultList();
		em.close();
		return allCustomers;
	}

	/**
	 * @param customerId
	 */
	public void deleteCustomer(Integer id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Customer toDelete = em.find(Customer.class, id);
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * @param id
	 * @return
	 */
	public Customer findGuest(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Customer foundGuest = em.find(Customer.class, id);
		em.getTransaction().commit();
		em.close();
		return foundGuest;
	}

	/**
	 * @param customer
	 */
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * @param customerId
	 * @return
	 */
	public Customer findCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Customer foundCustomer = em.find(Customer.class, customerId);
		em.getTransaction().commit();
		em.close();
		return foundCustomer;
	}

}
