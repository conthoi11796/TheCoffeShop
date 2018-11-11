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
public class UnitService implements UnitDAOImp {

	@Autowired
	UnitDAO unitDAO;

	@Override
	public Boolean addUnit(Unit unit) {
		// TODO Auto-generated method stub
		return unitDAO.addUnit(unit);
	}

	@Override
	public List<Unit> findAll() {
		// TODO Auto-generated method stub
		return unitDAO.findAll();
	}

	@Override
	public Unit getInfoById(String unitid) {
		// TODO Auto-generated method stub
		return unitDAO.getInfoById(unitid);
	}

	@Override
	public Boolean deleteUnit(String unitid) {
		// TODO Auto-generated method stub
		return unitDAO.deleteUnit(unitid);
	}

	@Override
	public Boolean editUnit(Unit unit) {
		// TODO Auto-generated method stub
		return unitDAO.editUnit(unit);
	}
	
}