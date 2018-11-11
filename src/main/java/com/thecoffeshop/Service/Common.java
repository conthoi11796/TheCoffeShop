package com.thecoffeshop.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thecoffeshop.Models.Price;
import com.thecoffeshop.Models.Product;
import com.thecoffeshop.DAOImp.*;

public class Common implements CommonDAOImp {

	public static String HOME_REDIRECT = "redirect:/admin/login";

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static SimpleDateFormat sdfDateField = new SimpleDateFormat("yyyy-MM-dd");
	
	public static SimpleDateFormat sdfTimeField = new SimpleDateFormat("hh:mm");

	/**
	 * check logined
	 * 
	 * @param HttpSession
	 */
	public Boolean checkLogIn(HttpSession httpSession) {
		if (httpSession.getAttribute("emId") == null) {
			// has a session emId
			return true;
		} else {
			return false;
		}
	}

	public int rateOldAndNewPrice(float oldPrice, float newPrice) {

		/* if old price = 0 -> product is new realease and dont start */
		if ((newPrice < oldPrice) && (oldPrice > 0)) {

			float result = (oldPrice - newPrice) / oldPrice * 100;

			return (int) result;
		}

		return 0;
	}

	public List<String> listProductCart(String listCart) {

		List<String> list = new ArrayList<String>();
		String listPId = listCart;
		while ((listPId.indexOf("~") != -1)) {
			String PId = listPId.substring(0, listPId.indexOf("~"));

			list.add(PId);

			listPId = listPId.substring(listPId.indexOf("~") + 1, listPId.length());
		}

		return list;
	}

	public List<Integer> listNumberCart(String listNumberProduct) {

		List<Integer> list = new ArrayList<Integer>();
		while ((listNumberProduct.indexOf("~") != -1)) {
			Integer number = Integer.valueOf(listNumberProduct.substring(0, listNumberProduct.indexOf("~")));

			list.add(number);
			
			listNumberProduct = listNumberProduct.substring(listNumberProduct.indexOf("~") + 1,
					listNumberProduct.length());
		}
		
		return list;
	}
}
