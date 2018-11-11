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
public class SupplierService implements SupplierDAOImp {

	@Autowired
	SupplierDAO supplierDAO;

	@Override
	public Boolean addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDAO.addSupplier(supplier);
	}

	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		return supplierDAO.findAll();
	}

	@Override
	public Supplier getInfoById(int supplierid) {
		// TODO Auto-generated method stub
		return supplierDAO.getInfoById(supplierid);
	}

	@Override
	public Boolean deleteSupplier(int supplierid) {
		// TODO Auto-generated method stub
		return supplierDAO.deleteSupplier(supplierid);
	}

	@Override
	public Boolean editSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDAO.editSupplier(supplier);
	}
}