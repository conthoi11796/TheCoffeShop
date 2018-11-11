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
public class DinnertableService implements DinnertableDAOImp {

	@Autowired
	DinnertableDAO dinnertableDAO;

	@Override
	public Boolean addDinnertable(Dinnertable dinnertable) {
		// TODO Auto-generated method stub
		return dinnertableDAO.addDinnertable(dinnertable);
	}

	@Override
	public List<Dinnertable> findAll() {
		// TODO Auto-generated method stub
		return dinnertableDAO.findAll();
	}

	@Override
	public Dinnertable getInfoById(int dinnertableid) {
		// TODO Auto-generated method stub
		return dinnertableDAO.getInfoById(dinnertableid);
	}

	@Override
	public Boolean deleteDinnertable(int dinnertableid) {
		// TODO Auto-generated method stub
		return dinnertableDAO.deleteDinnertable(dinnertableid);
	}

	@Override
	public Boolean editDinnertable(Dinnertable dinnertable) {
		// TODO Auto-generated method stub
		return dinnertableDAO.editDinnertable(dinnertable);
	}

}