package com.thecoffeshop.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexAdminController {
	@GetMapping(value = { "/admin/index" })
	public String index(Model model, HttpSession session) {

		model.addAttribute(session.getAttribute("emId"));
		return "/admin/index";

	}
}
