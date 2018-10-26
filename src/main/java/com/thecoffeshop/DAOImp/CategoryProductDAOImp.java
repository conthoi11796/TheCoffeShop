package com.thecoffeshop.DAOImp;

import java.util.List;
import com.thecoffeshop.Models.*;

public interface CategoryProductDAOImp {

	public static Boolean IS_DELETE = true;

	public static Boolean IS_NOT_DELETE = false;
	
	public List<Categoryproduct> findAll();
}
