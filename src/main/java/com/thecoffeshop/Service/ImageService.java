package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.ImageDAO;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Image;

@Service
@Transactional
public class ImageService implements ImageDAOImp {

	@Autowired
	private ImageDAO imageDAO;

	@Override
	public List<Image> getListImageOfProduct(String PId) {

		return imageDAO.getListImageOfProduct(PId);
	}

}
