package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.DAO.*;
import com.thecoffeshop.Models.Image;

public interface ImageDAOImp extends CommonDAOImp {

	public List<Image> getListImageOfProduct(String PId);

}
