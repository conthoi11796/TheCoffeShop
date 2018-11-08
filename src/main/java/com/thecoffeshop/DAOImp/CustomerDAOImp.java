package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.Customer;

public interface CustomerDAOImp extends CommonDAOImp{
	
	public int addCustomer(Customer customer);

	public List<Customer> findAll();

	public Customer getInfoById(int customerid);

	public Boolean deleteCustomer(int customerid);

	public Boolean editCustomer(Customer customer);
}
