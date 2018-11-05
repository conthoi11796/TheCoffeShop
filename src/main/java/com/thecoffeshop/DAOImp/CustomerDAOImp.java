package com.thecoffeshop.DAOImp;

import com.thecoffeshop.Models.Customer;

public interface CustomerDAOImp extends CommonDAOImp{
	
	public int addCustomer(Customer customer);
}
