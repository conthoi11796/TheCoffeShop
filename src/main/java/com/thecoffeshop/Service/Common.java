package com.thecoffeshop.Service;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thecoffeshop.Models.Price;
import com.thecoffeshop.Models.Product;
import com.thecoffeshop.DAOImp.*;

public class Common implements CommonDAOImp {

	public static String HOME_REDIRECT = "redirect:/admin/login";

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
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
}
