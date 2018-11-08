package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface SupplierDAOImp extends CommonDAOImp{

	public Boolean addSupplier(Supplier supplier);

	public List<Supplier> findAll();

	public Supplier getInfoById(int supplierid);

	public Boolean deleteSupplier(int supplierid);

	public Boolean editSupplier(Supplier supplier);
}
