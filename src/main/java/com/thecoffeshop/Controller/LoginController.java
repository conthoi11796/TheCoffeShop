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
	public String index() {

		return "/admin/login";

	}

	@PostMapping(value = { "/admin/login" })
	public String listCustomer(@RequestParam String emUsername, @RequestParam String emPassword, Model model,
			HttpSession session, HttpServletResponse servletResponse) {

		Employee employee = employeeService.logIn(emUsername, emPassword);

		model.addAttribute(employee);

		if (employee == null) {
			return "/admin/login";
		}

		session.setAttribute("emId", employee.getEmId());
//		return "/admin/index";
		
		return "redirect:/admin/index";

	}
}
