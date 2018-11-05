package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
			session.save(customer);
			return customer.getCuId();
		} catch (Exception e) {
			return 0;
		}
	}

}
