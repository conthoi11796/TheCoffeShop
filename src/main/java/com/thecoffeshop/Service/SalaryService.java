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
public class SalaryService implements SalaryDAOImp {

	@Autowired
	SalaryDAO salaryDAO;

	@Override
	public Boolean addSalary(Salary salary) {
		// TODO Auto-generated method stub
		return salaryDAO.addSalary(salary);
	}

	@Override
	public Salary getInfoById(int dinnertableid) {
		// TODO Auto-generated method stub
		return salaryDAO.getInfoById(dinnertableid);
	}

	@Override
	public Boolean deleteSalary(int dinnertableid) {
		// TODO Auto-generated method stub
		return salaryDAO.deleteSalary(dinnertableid);
	}

	@Override
	public Boolean editSalary(Salary salary) {
		// TODO Auto-generated method stub
		return salaryDAO.editSalary(salary);
	}

	@Override
	public int getSalaryByEmployeeid(String employeeid) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}