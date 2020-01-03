package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	// inject the SessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// create session from session factory
		Session currentSession = sessionFactory.getCurrentSession();

		// create query to get all the customers
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute the query
		List<Customer> listCustomers = theQuery.getResultList();

		// return the result
		return listCustomers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// create session from session factory
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {

		// create session from session factory
		Session currentSession = sessionFactory.getCurrentSession();

		Customer customer = currentSession.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// create session from session factory
		Session currentSession = sessionFactory.getCurrentSession();
		
		//------------------------------------------------------------------//
		// get the customer data for the given id
		//Customer theCustomer = currentSession.get(Customer.class, theId);
		
		// delete the customer
		//currentSession.delete(theCustomer);
		//------------------------------------------------------------------//
		
		//###### ANOTHER METHOD OF DELETING A RECORD ######
		Query<?> theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		
		Query<Customer> theQuery = null;
		
		// create session from session factory
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get the customer record if the given input is not null or empty
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery(
					"from Customer where lower(firstName) like :theSearchName or lower(lastName) like :theSearchName",
					Customer.class);
			theQuery.setParameter("theSearchName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			// if the input value for search name is null or empty get all the customer records
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		// get the list of customers based on the query
		List<Customer> theCustomers = theQuery.getResultList();
		
		// return the result
		return theCustomers;
	}

}
