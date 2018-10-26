package com.thecoffeshop.DAOImp;

import com.thecoffeshop.Models.Product;

public interface ProductDAOImp {

	public static Boolean IS_DELETE = true;

	public static Boolean IS_NOT_DELETE = false;
	
	public Boolean addProduct(Product product);
}
