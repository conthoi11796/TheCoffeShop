package com.thecoffeshop;

import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Common {
	/**
	 * check logined
	 * 
	 * @param HttpSession
	 */
	public String checkLogIn(HttpSession httpSession) {
		if (httpSession.getAttribute("emId") == null) {
			// has a session emId
			return "redirect:/admin/login";
		} else {
			return null;
		}
	}

	/**
	 * Convert String to Json
	 * 
	 * @param FormData
	 */
	public JsonObject convertStringToJson(String FormData) {
		// Format FormData : PName=adasd&cgPrdName=126&cgPrdName=
		// Format JSon {"firstName":"Sergey","lastName":"Kargopolov","lastName":""}

		/** Convert String to JSon String */

		/* Format FormData when "PName"="adasd","cgPrdName"="126","cgPrdName"=null */
		while (FormData.indexOf("null") != -1) {
			int postion = FormData.indexOf("null");
			FormData = FormData.substring(0, postion)+"\"\""
					+ FormData.substring(postion + "null".length(), FormData.length());

		}
//		System.out.println("[1]:"+ FormData);
		
		/* Format FormData when Format FormData : PName=adasd&cgPrdName=126&cgPrdName= */
		/* Repalce = to ":" */
		while (FormData.indexOf('=') != -1) {

			int postion = FormData.indexOf('=');
//			System.out.println(postion);
			/* substring 0 -> position of firt = */
//			System.out.println(FormData.substring(0, postion));
//			System.out.println(FormData.substring(postion + 1, FormData.length()));
			/* Repalce = to ":" */
			FormData = FormData.substring(0, postion) + "\":\"" + FormData.substring(postion + 1, FormData.length());
//			System.out.println("[2]:"+ FormData);
		}
		
		/* Format FormData when Format FormData : PName=adasd&cgPrdName=126&cgPrdName= */
		/* Repalce & to "," */
		while (FormData.indexOf('&') != -1) {

			int postion = FormData.indexOf('&');
//			System.out.println(postion);
			/* substring 0 -> position of firt & */
//			System.out.println(FormData.substring(0, postion));
//			System.out.println(FormData.substring(postion + 1, FormData.length()));
			/* Repalce & to "," */
			FormData = FormData.substring(0, postion) + "\",\"" + FormData.substring(postion + 1, FormData.length());
//			System.out.println("[3]:"+ FormData);
		}
//		"firstName":"Sergey","lastName":"Kargopolov","lastName":""
		if (FormData.indexOf("{") == -1) {
			FormData = "{\"" + FormData + "\"}";
		}
		System.out.println("-------JSon String: " + FormData);
		JsonParser jsonParser = new JsonParser();
		JsonObject objectFromString = jsonParser.parse(FormData).getAsJsonObject();
		return objectFromString;
	}

	/**
	 * Get Value by Key from JsonObject
	 * 
	 * @param JsonObject
	 */
	public String getValueJsonObject(JsonObject jsonObject, String Key) {

		String value = jsonObject.get(Key).toString();
		return value.substring(1, value.length() - 1);
	}
}
