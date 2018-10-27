package com.thecoffeshop.DAOImp;

import com.thecoffeshop.Models.Product;

public interface ProductDAOImp extends CommonDAOImp {

	public Boolean addProduct(Product product);
	
	public Product getInfoById(String PId);
}
