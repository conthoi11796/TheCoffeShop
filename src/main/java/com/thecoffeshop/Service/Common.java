package com.thecoffeshop.Service;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Common {

	public static String HOME_REDIRECT = "redirect:/admin/login";

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

	public String convertObjectToJsonString(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonString = mapper.writeValueAsString(object);
			
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
