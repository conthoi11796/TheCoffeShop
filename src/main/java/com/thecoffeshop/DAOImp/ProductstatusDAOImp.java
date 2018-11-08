package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface ProductstatusDAOImp extends CommonDAOImp{

	public Boolean addProductstatus(Productstatus productstatus);

	public List<Productstatus> findAll();

	public Productstatus getInfoById(int productstatusid);

	public Boolean deleteProductstatus(int productstatusid);

	public Boolean editProductstatus(Productstatus productstatus);
}
