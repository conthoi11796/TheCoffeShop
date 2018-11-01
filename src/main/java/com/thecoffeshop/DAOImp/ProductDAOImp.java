package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.Product;

public interface ProductDAOImp extends CommonDAOImp {

	public Boolean addProduct(Product product);

	public Product getInfoById(String PId);

	public List<Product> getListProductLimit(int startPosition, String cgPrdId, String strSearch);

	public Boolean checkIsNewProduct(String PId);

}
