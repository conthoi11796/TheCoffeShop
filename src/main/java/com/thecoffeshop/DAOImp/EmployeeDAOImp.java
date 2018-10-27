package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.Employee;
public interface EmployeeDAOImp extends CommonDAOImp{

	public String logIn(String username, String password);
	
	public Employee getInfoById(String emId);

	public List<Employee> findAll(int start, int numberRow);

	}
