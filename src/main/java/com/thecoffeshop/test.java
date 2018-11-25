package com.thecoffeshop;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {
	@GetMapping(value = { "/test" })
	public String index() {
		return "admin/public/xxx";
	}
}
