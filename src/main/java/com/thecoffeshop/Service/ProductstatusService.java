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
public class ProductstatusService implements ProductstatusDAOImp {
	
	@Autowired
	ProductstatusDAO productstatusDAO;

	@Override
	public Boolean addProductstatus(Productstatus productstatus) {
		// TODO Auto-generated method stub
		return productstatusDAO.addProductstatus(productstatus);
	}

	@Override
	public List<Productstatus> findAll() {
		// TODO Auto-generated method stub
		return productstatusDAO.findAll();
	}

	@Override
	public Productstatus getInfoById(int productstatusid) {
		// TODO Auto-generated method stub
		return productstatusDAO.getInfoById(productstatusid);
	}

	@Override
	public Boolean deleteProductstatus(int productstatusid) {
		// TODO Auto-generated method stub
		return productstatusDAO.deleteProductstatus(productstatusid);
	}

	@Override
	public Boolean editProductstatus(Productstatus productstatus) {
		// TODO Auto-generated method stub
		return productstatusDAO.editProductstatus(productstatus);
	}
}