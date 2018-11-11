package com.thecoffeshop.Service;

import java.util.Set;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.thecoffeshop.Models.Image;

public class Convert {

	// private JsonObject jsonObject;

	/**
	 * convert Java Object to Json String
	 * 
	 * @param Object, JsonObject
	 */
	public String ObjectToJson(Object object) {

		/* [Option 1] */
//			 ObjectMapper mapper = new ObjectMapper();
//			 String jsonInString=null;
//			try {
//				jsonInString = mapper.writeValueAsString(product);
//			} catch (JsonProcessingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		/* [Option 2] */
		Gson gson = new Gson();
		String jsonInString = gson.toJson(object);
		return jsonInString;
	}

	public JsonObject ObjectToJsonObject(Object object) {

		String jsonString = this.ObjectToJson(object);
		JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();

		return jsonObject;
	}

	public String SetImageToString(Set<Image> images) {

		String result = "[";

		for (Image image : images) {
			result += "'" + image.getImgName() + "',";
		}
		result = result.substring(0, result.length() - 1);
		result += "]";

		return result;
	}

	/**
	 * Convert String to Json
	 * 
	 * @param FormData
	 */
	/*
	 * public JsonObject SetJS(String FormData) { // FormData is String Format
	 * FormData : PName=adasd&cgPrdName=126&cgPrdName= // FormData is Stringwhen
	 * Format JSon // {"firstName":"Sergey","lastName":"Kargopolov","lastName":""}
	 * 
	 * // when is String: FormData=PName=adasd&cgPrdName=126&cgPrdName= if
	 * (FormData.indexOf("FormData=") != -1) { FormData = FormData.substring(9,
	 * FormData.length()); System.out.println(); }
	 * 
	 *//**
		 * Convert String to JSon String
		 */
	/*
	 * Format FormData when "PName"="adasd","cgPrdName"="126","cgPrdName"=null while
	 * (FormData.indexOf("null") != -1) { int postion = FormData.indexOf("null");
	 * FormData = FormData.substring(0, postion) + "\"\"" +
	 * FormData.substring(postion + "null".length(), FormData.length());
	 * 
	 * }
	 * 
	 * 
	 * * Format FormData when Format FormData : PName=adasd&cgPrdName=126&cgPrdName=
	 * 
	 * Repalce = to ":" while (FormData.indexOf('=') != -1) {
	 * 
	 * int postion = FormData.indexOf('='); // System.out.println(postion);
	 * substring 0 -> position of firt = // System.out.println(FormData.substring(0,
	 * postion)); // System.out.println(FormData.substring(postion + 1,
	 * FormData.length())); Repalce = to ":" FormData = FormData.substring(0,
	 * postion) + "\":\"" + FormData.substring(postion + 1, FormData.length()); //
	 * System.out.println("[2]:"+ FormData); }
	 * 
	 * 
	 * Format FormData when Format FormData : PName=adasd&cgPrdName=126&cgPrdName=
	 * 
	 * Repalce & to "," while (FormData.indexOf('&') != -1) {
	 * 
	 * int postion = FormData.indexOf('&'); // System.out.println(postion);
	 * substring 0 -> position of firt & // System.out.println(FormData.substring(0,
	 * postion)); // System.out.println(FormData.substring(postion + 1,
	 * FormData.length())); Repalce & to "," FormData = FormData.substring(0,
	 * postion) + "\",\"" + FormData.substring(postion + 1, FormData.length()); //
	 * System.out.println("[3]:"+ FormData); } //
	 * "firstName":"Sergey","lastName":"Kargopolov","lastName":"" if
	 * (FormData.charAt(0) != '{' && FormData.charAt(FormData.length() - 1) != '}')
	 * { FormData = "{\"" + FormData + "\"}"; }
	 * System.out.println("-------JSon String: " + FormData); JsonParser jsonParser
	 * = new JsonParser(); JsonObject objectFromString =
	 * jsonParser.parse(FormData).getAsJsonObject();
	 * 
	 * this.jsonObject = objectFromString; return jsonObject; }
	 * 
	 *//**
		 * Get Value by Key from JsonObject
		 * 
		 * @param JsonObject
		 *//*
			 * public String getJS(String Key) {
			 * 
			 * String value = this.jsonObject.get(Key).toString(); // result-> "value12"
			 * return value.substring(1, value.length() - 1); // result -> value12 }
			 */
}
