package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.thecoffeshop.DAOImp.CustomerDAOImp;
import com.thecoffeshop.Models.Customer;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class CustomerDAO implements CustomerDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			int lastID = (Integer) session.save(customer);

			return lastID;
		} catch (Exception e) {

			return -1;
		}
	}

	@Override
	public List<Customer> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Customer> customers = session
					.createQuery("FROM Customer c WHERE c.isdelete =: isdelete", Customer.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return customers;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Customer getInfoById(int customerid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Customer customer = session
					.createQuery("FROM Customer c WHERE c.customerid = :customerid AND c.isdelete =: isdelete",
							Customer.class)
					.setParameter("customerid", customerid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return customer;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteCustomer(int customerid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Customer customer = this.getInfoById(customerid);
			session.delete(customer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editCustomer(Customer customer) {
		return null;
	}

}
