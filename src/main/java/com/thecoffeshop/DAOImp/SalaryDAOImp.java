package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface SalaryDAOImp extends CommonDAOImp{

	public Boolean addSalary(Salary salary);

	public Salary getInfoById(int dinnertableid);

	public int getSalaryByEmployeeid(String employeeid);
	
	public Boolean deleteSalary(int dinnertableid);

	public Boolean editSalary(Salary salary);
}
