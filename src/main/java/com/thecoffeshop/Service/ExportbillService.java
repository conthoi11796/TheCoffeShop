package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.Models.*;
import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;

@Service
@Transactional
public class ExportbillService implements ExportbillDAOImp {

	@Autowired 
	ExportbillDAO exportbillDAO;

	@Override
	public Boolean addExportbill(Exportbill exportbill) {
		// TODO Auto-generated method stub
		return exportbillDAO.addExportbill(exportbill);
	}

	@Override
	public List<Exportbill> findAll() {
		// TODO Auto-generated method stub
		return exportbillDAO.findAll();
	}

	@Override
	public Exportbill getInfoById(int exportbillid) {
		// TODO Auto-generated method stub
		return exportbillDAO.getInfoById(exportbillid);
	}

	@Override
	public Boolean deleteExportbill(int exportbillid) {
		// TODO Auto-generated method stub
		return exportbillDAO.deleteExportbill(exportbillid);
	}

	@Override
	public Boolean editExportbill(Exportbill exportbill) {
		// TODO Auto-generated method stub
		return exportbillDAO.editExportbill(exportbill);
	}
}