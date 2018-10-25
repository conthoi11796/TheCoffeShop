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
	public Employee logIn(String username, String password) {

		Employee employee = emloyeeDAO.logIn(username, password);
		return employee;
		
	}

	public List<Employee> findAll() {
		return emloyeeDAO.findAll();
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
