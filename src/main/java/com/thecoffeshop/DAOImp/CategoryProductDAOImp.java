package com.thecoffeshop.DAOImp;

import java.util.List;
import com.thecoffeshop.Models.*;

public interface CategoryProductDAOImp extends CommonDAOImp {

	public List<Categoryproduct> findAll();

	public Boolean addCategoryProduct(Categoryproduct categoryproduct);
	
	public Categoryproduct getInfoById(String cgPrdId);
}
