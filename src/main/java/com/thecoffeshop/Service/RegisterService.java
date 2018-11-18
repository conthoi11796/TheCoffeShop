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
public class RegisterService implements RegisterDAOImp {

	@Autowired
	RegisterDAO registerDAO;

	@Override
	public Boolean addRegister(Register register) {
		// TODO Auto-generated method stub
		return registerDAO.addRegister(register);
	}

	@Override
	public Register getInfoById(RegisterId registerId) {
		// TODO Auto-generated method stub
		return registerDAO.getInfoById(registerId);
	}

	@Override
	public List<Register> getListRegisterOnWeek(int moth) {
		// TODO Auto-generated method stub
		return registerDAO.getListRegisterOnWeek(moth);
	}

	@Override
	public Boolean deleteRegister(RegisterId registerId) {
		// TODO Auto-generated method stub
		return registerDAO.deleteRegister(registerId);
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
}