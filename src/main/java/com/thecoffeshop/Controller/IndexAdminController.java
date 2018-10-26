package com.thecoffeshop.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thecoffeshop.Models.Employee;
import com.thecoffeshop.Service.EmployeeService;

@Controller
public class IndexAdminController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = { "/admin/index" })
	public String index(Model model, HttpSession httpSession) {

		// check logined
		if (httpSession.getAttribute("emId") == null) {
			return "redirect:/admin/login";
		}
		String emId = httpSession.getAttribute("emId").toString();
		Employee employee = employeeService.getInfoById(emId);
		model.addAttribute(employee);

		return "/admin/index";

	}
}
