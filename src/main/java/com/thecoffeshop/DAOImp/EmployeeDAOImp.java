package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.Employee;

public interface EmployeeDAOImp {
	
	public static Boolean IS_DELETE = true;

	public static Boolean IS_NOT_DELETE = false;

	public String logIn(String username, String password);
	
	public Employee getInfoById(String emId);

	public List<Employee> findAll();
	
}
