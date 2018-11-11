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
public class ProductService implements ProductDAOImp {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryProductDAO categoryProductDAO;

	@Override
	public Boolean addProduct(Product product) {

		return productDAO.addProduct(product);
	}

	@Override
	public Product getInfoById(String PId) {

		return productDAO.getInfoById(PId);
	}

	@Override
	public List<Product> getListProductLimit(int startPosition, String cgPrdId, String strSearch, String isHotDeal,
			String priceAZ, String priceZA) {

		return productDAO.getListProductLimit(startPosition, cgPrdId, strSearch, isHotDeal, priceAZ, priceZA);
	}

	@Override
	public Boolean checkIsNewProduct(String PId) {

		return productDAO.checkIsNewProduct(PId);
	}

	@Override
	public Boolean deleteProduct(String productid) {
		// TODO Auto-generated method stub
		return productDAO.deleteProduct(productid);
	}

	@Override
	public Boolean editProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.editProduct(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}

	@Override
	public Boolean checkExistNameProduct(String name) {
		// TODO Auto-generated method stub
		return productDAO.checkExistNameProduct(name);
	}

}
