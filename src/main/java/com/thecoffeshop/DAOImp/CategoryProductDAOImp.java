package com.thecoffeshop.DAOImp;

import java.util.List;
import com.thecoffeshop.Models.*;

public interface CategoryProductDAOImp extends CommonDAOImp {


	public Boolean addCategoryProduct(Categoryproduct categoryproduct);

	public List<Categoryproduct> findAll();
	
	public List<Categoryproduct> findLimit(int startPosition);
	
	public Categoryproduct getInfoById(String categoryproductid);

	public Boolean deleteCategoryproduct(String categoryproductid);

	public Boolean editCategoryproduct(Categoryproduct categoryproduct);
}
