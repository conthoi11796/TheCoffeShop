package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.Employee;
public interface EmployeeDAOImp extends CommonDAOImp{

	public List<Employee> findAll();

	public Boolean addEmployee(Employee employee);

	public String logIn(String username, String password);
	
	public Employee getInfoById(String employeeid);
	
	public Boolean checkExistUseName(String usename);

	public Boolean deleteEmployee(String employeeid);

	public Boolean editEmployee(Employee employee);

}
