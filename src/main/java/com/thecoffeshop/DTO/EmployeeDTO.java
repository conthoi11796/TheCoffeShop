package com.thecoffeshop.DTO;

import com.thecoffeshop.Models.*;

public class EmployeeDTO {

	private Employee employee;
	
	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
