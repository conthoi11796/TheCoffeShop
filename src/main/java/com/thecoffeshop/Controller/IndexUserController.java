package com.thecoffeshop.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thecoffeshop.Models.Employee;

@Controller
public class IndexUserController {

	@GetMapping(value = { "/index" })
	public String index(Model model, HttpSession httpSession) {

		return "/user/index";

	}
}
