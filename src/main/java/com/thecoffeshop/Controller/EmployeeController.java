package com.thecoffeshop.Controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.thecoffeshop.DTO.*;
import com.thecoffeshop.Models.*;
import com.thecoffeshop.Service.*;

@Controller
public class EmployeeController extends Common {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	PositionService positionService;
	@Autowired
	AtpositionService atpositionService;
	@Autowired
	SalaryService salaryService;

	@GetMapping(value = "/admin/employee")
	public String index(ModelMap modelMap, HttpSession httpSession) {

		List<Position> positions = positionService.findAll();
		modelMap.addAttribute("positions", positions);

		return "/admin/employee";
	}

	@GetMapping(value = "/admin/employee/table")
	public String tbody(ModelMap modelMap, HttpSession httpSession) {

		List<Employee> employees = employeeService.findAll();
		modelMap.addAttribute("employees", employees);

		return "/admin/content/employee/tBody";
	}

	@PostMapping(value = "/admin/employee/insert")
	public String insert(ModelMap modelMap, HttpSession httpSession, @RequestParam String employeeid,
			@RequestParam String name, @RequestParam String sex, @RequestParam String phone,
			@RequestParam String address, @RequestParam String usename, @RequestParam String password,
			@RequestParam String position, @RequestParam String salaryonhour, @RequestParam String startdate)
			throws ParseException {

		if (employeeService.getInfoById(employeeid.trim()) != null) {

			modelMap.addAttribute("result", "Mã đã tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}
		if (employeeService.checkExistUseName(usename.trim())) {

			modelMap.addAttribute("result", "Tài khoản đã tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		Employee employee = new Employee();
		employee.setEmployeeid(employeeid.trim());
		employee.setName(usename);
		if (sex != "Male") {
			employee.setSex(true);
		}
		if (sex != "FeMale") {
			employee.setSex(false);
		}
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setUsename(usename);
		employee.setPassword(password);
		employeeService.addEmployee(employee);

		Atposition atposition = new Atposition();
		atposition.setEmployee(employee);
		atposition.setCreateat(new Date());
//		atposition.setCreateby(createby);
		atposition.setUpdateat(new Date());
		atposition.setStartdate(super.sdfDateField.parse(startdate));
		atposition.setIsdelete(super.IS_NOT_DELETE);
		atpositionService.addAtposition(atposition);

		Salary salary = new Salary();
		salary.setSalaryonhour(Integer.valueOf(salaryonhour.trim()));
		salary.setCreateat(new Date());
		salary.setStartdate(super.sdfDateField.parse(startdate));
//		salary.setCreateby(createby);
		salary.setUpdateat(new Date());
		salary.setIsdelete(super.IS_NOT_DELETE);
		salaryService.addSalary(salary);

		modelMap.addAttribute("result", "Thêm thành công!");
		return "/admin/public/Success"; // thành công
	}

//
//	@PostMapping(value = "/admin/bill-status/remove")
//	public String remove(ModelMap modelMap, HttpSession httpSession, @RequestParam String billstatusid) {
//
//		Billstatus billstatus = billstatusService.getInfoById(billstatusid.trim());
//		if (billstatus == null) {
//			modelMap.addAttribute("result", "Trạng thái hóa đơn không tồn tại!");
//			return "/admin/public/Danger";// đã tồn tại
//		}
//		billstatus.setIsdelete(this.IS_DELETE);
//		billstatusService.editBilldetail(billstatus);
//
//		modelMap.addAttribute("result", "Xóa thành công!");
//		return "/admin/public/Success";// đã tồn tại
//	}
//
	@GetMapping(value = "/admin/employee/edit")
	public String view(ModelMap modelMap, HttpSession httpSession, @RequestParam String employeeid) {

		Employee employee = employeeService.getInfoById(employeeid.trim());
		if (employee == null) {
			modelMap.addAttribute("result", "Nhân viên không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}
		modelMap.addAttribute("employee", employee);

		return "/admin/content/employee/form";
	}
//
//	@PostMapping(value = "/admin/bill-status/edit")
//	public String edit(ModelMap modelMap, HttpSession httpSession, @RequestParam String billstatusid,
//			@RequestParam String name) {
//
//		Billstatus billstatus = billstatusService.getInfoById(billstatusid.trim());
//		if (billstatus == null) {
//			modelMap.addAttribute("result", "Trạng thái hóa đơn không tồn tại!");
//			return "/admin/public/Danger";// đã tồn tại
//		}
//
//		billstatus.setName(name);
//		billstatusService.editBilldetail(billstatus);
//
//		modelMap.addAttribute("result", "Cập nhật thành công!");
//		return "/admin/public/Success";
//	}
}
