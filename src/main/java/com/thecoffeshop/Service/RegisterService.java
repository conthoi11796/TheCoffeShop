package com.thecoffeshop.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Service
@Transactional
public class RegisterService implements RegisterDAOImp {

	@Autowired
	RegisterDAO registerDAO;

	@Override
	public Boolean addRegister(Register register) {
		// TODO Auto-generated method stub
		return registerDAO.addRegister(register);
	}

	@Override
	public Register getInfoById(int registerid) {
		// TODO Auto-generated method stub
		return registerDAO.getInfoById(registerid);
	}

	@Override
	public List<Register> getListRegisterOnWeek(Date from, Date to) {
		// TODO Auto-generated method stub
		return registerDAO.getListRegisterOnWeek(from, to);
	}

	@Override
	public Boolean deleteRegister(Register register) {
		// TODO Auto-generated method stub
		return registerDAO.deleteRegister(register);
	}

	@Override
	public Boolean editRegister(Register register) {
		// TODO Auto-generated method stub
		return registerDAO.editRegister(register);
	}

	@Override
	public Boolean checkExistSchedule(String scheduleid) {
		// TODO Auto-generated method stub
		return registerDAO.checkExistSchedule(scheduleid);
	}

	@Override
	public List<Register> listByDateScheduleid(Date date, String scheduleid) {
		// TODO Auto-generated method stub
		return registerDAO.listByDateScheduleid(date, scheduleid);
	}
}