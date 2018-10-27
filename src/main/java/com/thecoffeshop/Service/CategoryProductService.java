package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Categoryproduct;

@Service
@Transactional
public class CategoryProductService implements CategoryProductDAOImp {

	@Autowired 
	private CategoryProductDAO categoryProductDAO;
	
	@Override
	public List<Categoryproduct> findAll() {

		return categoryProductDAO.findAll();
	}

	@Override
	public Boolean addCategoryProduct(Categoryproduct categoryproduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoryproduct getInfoById(String cgPrdId) {
		
		return categoryProductDAO.getInfoById(cgPrdId);
	}

}
