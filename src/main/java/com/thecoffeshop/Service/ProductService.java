package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.ProductDAO;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Product;

@Service
@Transactional
public class ProductService implements ProductDAOImp {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public Boolean addProduct(Product product) {

		return productDAO.addProduct(product);
	}

	@Override
	public Product getInfoById(String PId) {

		return productDAO.getInfoById(PId);
	}

	@Override
	public List<Product> getListProductLimit(int startPosition, String cgPrdId, String strSearch) {

		return productDAO.getListProductLimit(startPosition, cgPrdId, strSearch);
	}

	@Override
	public Boolean checkIsNewProduct(String PId) {

		return productDAO.checkIsNewProduct(PId);
	}

}
