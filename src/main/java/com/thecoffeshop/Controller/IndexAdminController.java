package com.thecoffeshop.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thecoffeshop.DTO.indexAdminDTO;
import com.thecoffeshop.Models.*;
import com.thecoffeshop.Service.*;

@Controller
public class IndexAdminController {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	DinnertableService dinnertableService;
	@Autowired
	TablestatusdetailService tablestatusdetailService;

	@GetMapping(value = { "/admin/index" })
	public String index(Model model, HttpSession httpSession) {

		// check logined
		if (httpSession.getAttribute("emId") == null) {
			return "redirect:/admin/login";
		}
		String emId = httpSession.getAttribute("emId").toString();
		Employee employee = employeeService.getInfoById(emId);
		model.addAttribute(employee);

		List<indexAdminDTO> indexAdminDTOs = new ArrayList<indexAdminDTO>();
		List<Dinnertable> dinnertables = dinnertableService.findAll();

		for (Dinnertable dinnertable : dinnertables) {
			indexAdminDTO indexAdminDTO = new indexAdminDTO();
			indexAdminDTO.setDinnertable(dinnertable);

			tablestatusdetailService.getInfoById(dinnertable.getDinnertableid());
			
			indexAdminDTOs.add(indexAdminDTO);
		}

		return "/admin/management-system/index";

	}

}
