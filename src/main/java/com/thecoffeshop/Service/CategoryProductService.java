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
	public Boolean addCategoryProduct(Categoryproduct categoryproduct) {
		// TODO Auto-generated method stub
		return categoryProductDAO.addCategoryProduct(categoryproduct);
	}

	@Override
	public List<Categoryproduct> findAll() {

		return categoryProductDAO.findAll();
	}

	@Override
	public Categoryproduct getInfoById(String categoryproductid) {

		return categoryProductDAO.getInfoById(categoryproductid);
	}

	@Override
	public Boolean deleteCategoryproduct(String categoryproductid) {
		// TODO Auto-generated method stub
		return categoryProductDAO.deleteCategoryproduct(categoryproductid);
	}

	@Override
	public Boolean editCategoryproduct(Categoryproduct categoryproduct) {
		// TODO Auto-generated method stub
		return categoryProductDAO.editCategoryproduct(categoryproduct);
	}

	@Override
	public List<Categoryproduct> findLimit(int startPosition) {
		// TODO Auto-generated method stub
		return categoryProductDAO.findLimit(startPosition);
	}

}
