package com.thecoffeshop.Service;

import javax.servlet.http.HttpSession;

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
}
