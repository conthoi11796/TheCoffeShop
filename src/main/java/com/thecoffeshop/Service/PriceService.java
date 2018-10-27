package com.thecoffeshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.PriceDAO;
import com.thecoffeshop.DAO.ProductDAO;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Price;

@Service
@Transactional
public class PriceService implements PriceDAOImp {

	@Autowired
	private PriceDAO priceDAO;
	
	@Override
	public Boolean addPrice(Price price) {
		return priceDAO.addPrice(price);
	}

}