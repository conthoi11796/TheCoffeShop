package com.thecoffeshop.Controller;

import java.util.ArrayList;
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
public class BillController extends Common {

	@Autowired
	BillService billService;
	@Autowired
	BilldetailService billdetailService;

	@GetMapping(value = "/admin/bill")
	public String index(ModelMap modelMap, HttpSession httpSession) {

		int totalPage = billService.findAll().size() / super.MAX_RESULTS;
		if ((billService.findAll().size() % super.MAX_RESULTS) > 0) {
			totalPage++;
		}
		modelMap.addAttribute("totalPage", totalPage);

		return "/admin/bill";
	}

	@GetMapping(value = "/admin/bill/table")
	public String tbody(ModelMap modelMap, HttpSession httpSession, @RequestParam String startPosition) {
		
		List<Bill> bills = billService.findLimit(Integer.valueOf(startPosition.trim()) - 1);

		List<BillDTO> dtos = new ArrayList<BillDTO>();
		for (Bill bill : bills) {
			BillDTO billDTO = new BillDTO();
			billDTO.setBill(bill);
			billDTO.setTableName(bill.getDinnertable().getName());
			billDTO.setTotalPrice(123);
			billDTO.setBillstatus(bill.getBillstatus());

			dtos.add(billDTO);
		}
		modelMap.addAttribute("dtos", dtos);

		return "/admin/content/bill/tBody";
	}

//
//	@PostMapping(value = "/admin/bill/insert")
//	public String insert(ModelMap modelMap, HttpSession httpSession, @RequestParam String billstatusid,
//			@RequestParam String name) {
//
//		/* check */
//		List<String> results = checkForm(billstatusid, name);
//		if (results.size() > 0) {
//			modelMap.addAttribute("results", results);
//			return "/admin/public/Danger";// đã tồn tại
//		}
//		/* check[END] */
//
//		if (billstatusService.getInfoById(billstatusid.trim()) != null) {
//
//			modelMap.addAttribute("results", "Mã đã tồn tại!");
//			return "/admin/public/Danger";// đã tồn tại
//		}
//
//		Billstatus billstatus = new Billstatus();
//		billstatus.setBillstatusid(billstatusid);
//		billstatus.setName(name.trim());
////		billstatus.setCreateby(createby);
//		billstatus.setCreateat(new Date());
//		billstatus.setIsdelete(this.IS_NOT_DELETE);
//		billstatusService.addBillstatus(billstatus);
//
//		List<Billstatus> ListBillstatus = billstatusService.findAll();
//		modelMap.addAttribute("ListBillstatus", ListBillstatus);
//
//		modelMap.addAttribute("result", "Thêm thành công!");
//		return "/admin/public/Success"; // thành công
//	}
//
//	@PostMapping(value = "/admin/bill/remove")
//	public String remove(ModelMap modelMap, HttpSession httpSession, @RequestParam String billstatusid) {
//
//		Billstatus billstatus = billstatusService.getInfoById(billstatusid.trim());
//		if (billstatus == null) {
//			modelMap.addAttribute("results", "Trạng thái hóa đơn không tồn tại!");
//			return "/admin/public/Danger";// đã tồn tại
//		}
//		billstatus.setIsdelete(this.IS_DELETE);
//		billstatusService.editBilldetail(billstatus);
//
//		modelMap.addAttribute("result", "Xóa thành công!");
//		return "/admin/public/Success";// đã tồn tại
//	}
//
	@GetMapping(value = "/admin/bill/edit")
	public String view(ModelMap modelMap, HttpSession httpSession, @RequestParam String billid) {

		System.out.println(billid);
		
		Bill bill = billService.getInfoById(Integer.valueOf(billid.trim()));
		if (bill == null) {
			modelMap.addAttribute("results", "Hoá đơn không tồn tại!");
			return "/admin/public/Danger";
		}

		List<Billdetail> billdetails = billdetailService.getInfoBilldetailByBillId(Integer.valueOf(billid.trim()));
		List<BillDetailDTO> dtos = new ArrayList<BillDetailDTO>();
		for (Billdetail billdetail : billdetails) {
			BillDetailDTO billDetailDTO = new BillDetailDTO();
			
			billDetailDTO.setBilldetail(billdetail);

			dtos.add(billDetailDTO);
		}

		modelMap.addAttribute("dtos", dtos);

		return "/admin/content/bill/tBodyDetail";
	}
//
//	@PostMapping(value = "/admin/bill/edit")
//	public String edit(ModelMap modelMap, HttpSession httpSession, @RequestParam String billstatusid,
//			@RequestParam String name) {
//
//		/* check */
//		List<String> results = checkForm(billstatusid, name);
//		if (results.size() > 0) {
//			modelMap.addAttribute("results", results);
//			return "/admin/public/Danger";// đã tồn tại
//		}
//		/* check[END] */
//
//		Billstatus billstatus = billstatusService.getInfoById(billstatusid.trim());
//		if (billstatus == null) {
//			modelMap.addAttribute("results", "Trạng thái hóa đơn không tồn tại!");
//			return "/admin/public/Danger";// đã tồn tại
//		}
//
//		billstatus.setName(name);
//		billstatusService.editBilldetail(billstatus);
//
//		modelMap.addAttribute("result", "Cập nhật thành công!");
//		return "/admin/public/Success";
//	}
//
//	public List<String> checkForm(String billstatusid, String name) {
//		List<String> results = new ArrayList<String>();
//		if (billstatusid.length() == 0 || billstatusid.length() > 8) {
//
//			results.add("Mã phải không được để trống và tối đa 7 kí tự!");
//		}
//		if (name.length() == 0) {
//
//			results.add("Tên không được để trống!");
//		}
//		return results;
//	}
}
