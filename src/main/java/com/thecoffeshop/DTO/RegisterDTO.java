package com.thecoffeshop.DTO;

import java.util.List;

import com.thecoffeshop.Models.Employee;
import com.thecoffeshop.Models.Register;

public class RegisterDTO {

	private int day;

	private String scheduleid;

	private List<Register> registers;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}

	public List<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}

}
