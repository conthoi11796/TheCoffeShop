package com.thecoffeshop.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thecoffeshop.DTO.BillDTO;
import com.thecoffeshop.DTO.BillDetailDTO;
import com.thecoffeshop.Models.Bill;
import com.thecoffeshop.Models.Billdetail;
import com.thecoffeshop.Models.BilldetailId;
import com.thecoffeshop.Service.BillService;
import com.thecoffeshop.Service.BilldetailService;
import com.thecoffeshop.Service.Common;
import com.thecoffeshop.Service.PriceService;

@Controller
public class BillController extends Common {

	@Autowired
	BillService billService;
	@Autowired
	BilldetailService billdetailService;
	@Autowired
	PriceService priceService;

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
			billDTO.setTotalPrice(billService.getTotalPriceOfBill(bill.getBillid()));
			billDTO.setBillstatus(bill.getBillstatus());

			dtos.add(billDTO);
		}
		modelMap.addAttribute("dtos", dtos);

		return "/admin/content/bill/tBody";
	}

	@PostMapping(value = "/admin/bill/remove")
	public String remove(ModelMap modelMap, HttpSession httpSession, @RequestParam String billid) {

		Bill bill = billService.getInfoById(Integer.valueOf(billid.trim()));
		if (bill == null) {
			modelMap.addAttribute("results", "Hoá đơn không tồn tại!");
			return "/admin/public/Danger";
		}

		Set<Billdetail> billdetails = bill.getBilldetails();
		for (Billdetail billdetail : billdetails) {
			billdetail.setIsdelete(IS_DELETE);
			billdetail.setDeleteat(new Date());
//			billdetail.setDeleteby(deleteby);
			billdetailService.editBilldetail(billdetail);
		}

		bill.setIsdelete(this.IS_DELETE);
//		bill.setDeleteby(deleteby);
		bill.setDeleteat(new Date());
		billService.editBill(bill);

		modelMap.addAttribute("result", "Xóa thành công!");
		return "/admin/public/Success";// đã tồn tại
	}

	@GetMapping(value = "/admin/bill/edit")
	public String view(ModelMap modelMap, HttpSession httpSession, @RequestParam String billid) {

		Bill bill = billService.getInfoById(Integer.valueOf(billid.trim()));
		if (bill == null) {
			modelMap.addAttribute("results", "Hoá đơn không tồn tại!");
			return "/admin/public/Danger";
		}

		Date startdatetime = bill.getStartdatetime();

		List<Billdetail> billdetails = billdetailService.getInfoBilldetailByBillId(Integer.valueOf(billid.trim()));
		List<BillDetailDTO> dtos = new ArrayList<BillDetailDTO>();
		for (Billdetail billdetail : billdetails) {
			String productId = billdetail.getProduct().getProductid();

			BillDetailDTO billDetailDTO = new BillDetailDTO();
			billDetailDTO.setBilldetail(billdetail);
			billDetailDTO.setSinglePrice(billdetailService.getSinglePriceOfBillDetail(productId, startdatetime));

			billDetailDTO.setTotalPrice(billdetailService
					.getPriceOfBillDetail(new BilldetailId(productId, Integer.valueOf(billid.trim()))));

			dtos.add(billDetailDTO);
		}

		modelMap.addAttribute("dtos", dtos);

		return "/admin/content/bill/tBodyDetail";
	}

	@PostMapping(value = "/admin/billDetail/remove")
	public String remove(ModelMap modelMap, HttpSession httpSession, @RequestParam String billid,
			@RequestParam String productid) {

		Billdetail billdetail = billdetailService
				.getInfoBilldetailByBilldetailId(new BilldetailId(productid.trim(), Integer.valueOf(billid.trim())));

		if (billdetail == null) {
			modelMap.addAttribute("results", "Chi tiết hóa đơn không tồn tại!");
			return "/admin/public/Danger";
		}

		billdetail.setIsdelete(this.IS_DELETE);
//		billdetail.setDeleteby(deleteby);
		billdetail.setDeleteat(new Date());
		billdetailService.editBilldetail(billdetail);

		modelMap.addAttribute("result", "Xóa thành công!");
		return "/admin/public/Success";// đã tồn tại
	}

	@GetMapping(value = "/admin/billDetail/edit")
	public String viewBillDetail(ModelMap modelMap, HttpSession httpSession, @RequestParam String billid,
			@RequestParam String productid) {

		Billdetail billdetail = billdetailService
				.getInfoBilldetailByBilldetailId(new BilldetailId(productid.trim(), Integer.valueOf(billid.trim())));

		if (billdetail == null) {
			modelMap.addAttribute("results", "Chi tiết hóa đơn không tồn tại!");
			return "/admin/public/Danger";
		}

		modelMap.addAttribute("billdetail", billdetail);
		return "/admin/content/bill/form";
	}

	@PostMapping(value = "/admin/billDetail/edit")
	public String editBillDetail(ModelMap modelMap, HttpSession httpSession, @RequestParam String billid,
			@RequestParam String productid, @RequestParam String quantity) {

		/* check */
		List<String> results = checkForm(quantity);
		if (results.size() > 0) {
			modelMap.addAttribute("results", results);
			return "/admin/public/Danger";
		}
		/* check[END] */
		
		Billdetail billdetail = billdetailService
				.getInfoBilldetailByBilldetailId(new BilldetailId(productid.trim(), Integer.valueOf(billid.trim())));

		if (billdetail == null) {
			modelMap.addAttribute("results", "Chi tiết hóa đơn không tồn tại!");
			return "/admin/public/Danger";
		}
		
		billdetail.setQuantity(Integer.valueOf(quantity.trim()));

		billdetailService.editBilldetail(billdetail);

		modelMap.addAttribute("result", "Cập nhật thành công!");
		return "/admin/public/Success";
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
	public List<String> checkForm(String quantity) {
		List<String> results = new ArrayList<String>();
		if (quantity.trim().length() == 0 || Integer.valueOf(quantity.trim()) <= 0) {

			results.add("Số lượng không được để trống và phải lớn hơn 0!");
		}
		return results;
	}
}
