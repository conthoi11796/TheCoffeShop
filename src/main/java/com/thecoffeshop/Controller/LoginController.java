package com.thecoffeshop.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thecoffeshop.Models.Employee;
import com.thecoffeshop.Service.EmployeeService;

@Controller
public class LoginController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = { "/admin/login" })
	public String index(HttpSession httpSession) {

		// check logined
		if (httpSession.getAttribute("emId") != null) {
			return "redirect:/admin/index";
		}
		return "/admin/login";

	}

	@PostMapping(value = { "/admin/login" })
	public String index(@RequestParam String emUsername, @RequestParam String emPassword, Model model,
			HttpSession httpSession, HttpServletResponse servletResponse) {

		String emId = employeeService.logIn(emUsername, emPassword);

		if (emId == null) {
			model.addAttribute("error", "Sai mật khẩu hoặc tài khoản");
			return "/admin/login";
		}
		httpSession.setAttribute("emId", emId);

		return "redirect:/admin/index";

	}
}
