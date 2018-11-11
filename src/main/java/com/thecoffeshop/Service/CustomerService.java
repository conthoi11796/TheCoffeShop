package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Service
@Transactional
public class CustomerService implements CustomerDAOImp {

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.addCustomer(customer);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDAO.findAll();
	}

	@Override
	public Customer getInfoById(int customerid) {
		// TODO Auto-generated method stub
		return customerDAO.getInfoById(customerid);
	}

	@Override
	public Boolean deleteCustomer(int customerid) {
		// TODO Auto-generated method stub
		return customerDAO.deleteCustomer(customerid);
	}

	@Override
	public Boolean editCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.editCustomer(customer);
	}

}
