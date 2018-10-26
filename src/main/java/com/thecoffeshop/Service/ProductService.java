package com.thecoffeshop.Service;

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

}
