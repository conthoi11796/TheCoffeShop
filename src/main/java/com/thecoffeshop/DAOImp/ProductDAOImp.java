package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.Product;

public interface ProductDAOImp extends CommonDAOImp {

	public Boolean addProduct(Product product);

	public List<Product> getListProductLimit(int startPosition, String cgPrdId, String strSearch);

	public Product getInfoById(String productid);
	
	public Boolean checkIsNewProduct(String productid);

	public Boolean deleteProduct(String productid);

	public Boolean editProduct(Product product);
}
