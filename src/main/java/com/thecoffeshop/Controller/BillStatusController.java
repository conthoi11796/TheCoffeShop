package com.thecoffeshop.Controller;

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
public class BillStatusController extends Common {

	@Autowired
	BillstatusService billstatusService;

	@GetMapping(value = "/admin/bill-status")
	public String index(ModelMap modelMap, HttpSession httpSession) {

		return "/admin/bill-status";
	}

	@GetMapping(value = "/admin/bill-status/table")
	public String tbody(ModelMap modelMap, HttpSession httpSession) {

		List<Billstatus> ListBillstatus = billstatusService.findAll();
		modelMap.addAttribute("ListBillstatus", ListBillstatus);

		return "/admin/content/bill-status/tBody";
	}

	@PostMapping(value = "/admin/bill-status/insert")
	public String insert(ModelMap modelMap, HttpSession httpSession, @RequestParam String billstatusid,
			@RequestParam String name) {

		if (billstatusService.getInfoById(billstatusid.trim()) != null) {

			modelMap.addAttribute("result", "Mã đã tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		Billstatus billstatus = new Billstatus();
		billstatus.setBillstatusid(billstatusid);
		billstatus.setName(name.trim());
//		billstatus.setCreateby(createby);
		billstatus.setCreateat(new Date());
		billstatus.setIsdelete(this.IS_NOT_DELETE);
		billstatusService.addBillstatus(billstatus);

		List<Billstatus> ListBillstatus = billstatusService.findAll();
		modelMap.addAttribute("ListBillstatus", ListBillstatus);

		modelMap.addAttribute("result", "Thêm thành công!");
		return "/admin/public/Success"; // thành công
	}

	@PostMapping(value = "/admin/bill-status/remove")
	public String remove(ModelMap modelMap, HttpSession httpSession, @RequestParam String billstatusid) {

		Billstatus billstatus = billstatusService.getInfoById(billstatusid.trim());
		if (billstatus == null) {
			modelMap.addAttribute("result", "Trạng thái hóa đơn không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}
		billstatus.setIsdelete(this.IS_DELETE);
		billstatusService.editBilldetail(billstatus);

		modelMap.addAttribute("result", "Xóa thành công!");
		return "/admin/public/Success";// đã tồn tại
	}

	@GetMapping(value = "/admin/bill-status/edit")
	public String view(ModelMap modelMap, HttpSession httpSession, @RequestParam String billstatusid) {

		Billstatus billstatus = billstatusService.getInfoById(billstatusid.trim());
		if (billstatus == null) {
			modelMap.addAttribute("result", "Trạng thái hóa đơn không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		modelMap.addAttribute("billstatus", billstatus);
		return "/admin/content/bill-status/form";
	}

	@PostMapping(value = "/admin/bill-status/edit")
	public String edit(ModelMap modelMap, HttpSession httpSession, @RequestParam String billstatusid,
			@RequestParam String name) {

		Billstatus billstatus = billstatusService.getInfoById(billstatusid.trim());
		if (billstatus == null) {
			modelMap.addAttribute("result", "Trạng thái hóa đơn không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		billstatus.setName(name);
		billstatusService.editBilldetail(billstatus);

		modelMap.addAttribute("result", "Cập nhật thành công!");
		return "/admin/public/Success";
	}
}
