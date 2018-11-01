package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;
import com.thecoffeshop.DAOImp.*;


public interface PriceDAOImp extends CommonDAOImp {

	public Boolean addPrice(Price price);
	
	public Price getInfoById(String prId);
	
	public Price getInfoByProduct(String PId);
	
	/*get price will apply*/
	public Price getNewPrice(String PId);
	
	/*get price applied*/
	public int getOldPrice(String PId);
	
}
