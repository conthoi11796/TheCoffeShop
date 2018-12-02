package com.thecoffeshop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

@Controller
public class test {
	@GetMapping(value = { "/test" })
	public String index() {

		JsonObject result2 = new JsonObject();
		result2.addProperty("mes", "Bàn này không tồn tại!");
		result2.addProperty("mes", "Bàn này không tồn tại!");
		
		List<JsonObject> list = new ArrayList<JsonObject>(); 
		list.add(result2);
		list.add(result2);
		
		JsonObject result = new JsonObject();
		result.addProperty("x", list.toString());
		
		System.out.println(result.toString());
		
		
		
		return "admin/public/xxx";
	}
}
