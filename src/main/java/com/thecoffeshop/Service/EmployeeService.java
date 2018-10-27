package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.Models.*;
import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.EmployeeDAOImp;

@Service
@Transactional
public class EmployeeService implements EmployeeDAOImp {

	@Autowired
	private EmloyeeDAO emloyeeDAO;

	@Override
	public String logIn(String username, String password) {

		return emloyeeDAO.logIn(username, password);

	}

	@Override
	public Employee getInfoById(String emId) {

		return emloyeeDAO.getInfoById(emId);
	}

	@Override
	public List<Employee> findAll(int start, int numberRow) {
		
		return emloyeeDAO.findAll(start, numberRow);
	}

//	public Customer findById(final int id) {
//		return customerDAO.findById(id);
//	}
//
//	public void save(final Customer customer) {
//		customerDAO.save(customer);
//	}
//
//	public void update(final Customer customer) {
//		customerDAO.update(customer);
//	}
//
//	public void delete(final int id) {
//		Customer customer = customerDAO.findById(id);
//		if (customer != null) {
//			customerDAO.delete(customer);
//		}
//	}
}
