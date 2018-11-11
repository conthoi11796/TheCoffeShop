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
public class TablestatusdetailService implements TablestatusdetailDAOImp {

	@Autowired
	TablestatusdetailDAO tablestatusdetailDAO;

	@Override
	public Boolean addTablestatusdetail(Tablestatusdetail tablestatusdetail) {
		// TODO Auto-generated method stub
		return tablestatusdetailDAO.addTablestatusdetail(tablestatusdetail);
	}

	@Override
	public List<Tablestatusdetail> findAll() {
		// TODO Auto-generated method stub
		return tablestatusdetailDAO.findAll();
	}

	@Override
	public Tablestatusdetail getInfoById(int dinnertableidId) {
		// TODO Auto-generated method stub
		return tablestatusdetailDAO.getInfoById(dinnertableidId);
	}

	@Override
	public Boolean deleteTablestatusdetail(TablestatusdetailId tablestatusdetailId) {
		// TODO Auto-generated method stub
		return tablestatusdetailDAO.deleteTablestatusdetail(tablestatusdetailId);
	}

	@Override
	public Boolean editTablestatusdetail(Tablestatusdetail tablestatusdetail) {
		// TODO Auto-generated method stub
		return tablestatusdetailDAO.editTablestatusdetail(tablestatusdetail);
	}

}