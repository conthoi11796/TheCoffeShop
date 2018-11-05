package com.thecoffeshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.CustomerDAO;
import com.thecoffeshop.DAOImp.CustomerDAOImp;
import com.thecoffeshop.Models.Customer;

@Service
@Transactional
public class CustomerService implements CustomerDAOImp {

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public int addCustomer(Customer customer) {

		return customerDAO.addCustomer(customer);
	}

}
