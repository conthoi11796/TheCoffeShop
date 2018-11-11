package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.Product;

public interface ProductDAOImp extends CommonDAOImp {

	public Boolean addProduct(Product product);

	public List<Product> findAll();
	
	public List<Product> getListProductLimit(int startPosition, String cgPrdId, String strSearch, String isHotDeal,
			String priceAZ, String priceZA);

	public Product getInfoById(String productid);
	
	public Boolean checkExistNameProduct(String name);

	public Boolean checkIsNewProduct(String productid);

	public Boolean deleteProduct(String productid);

	public Boolean editProduct(Product product);
}
