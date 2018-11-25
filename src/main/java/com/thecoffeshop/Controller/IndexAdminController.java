package com.thecoffeshop.Controller;

import java.awt.dnd.DnDConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thecoffeshop.DTO.BillDetailDTO;
import com.thecoffeshop.DTO.ProductDTO;
import com.thecoffeshop.DTO.indexAdminDTO;
import com.thecoffeshop.Models.*;
import com.thecoffeshop.Service.*;

@Controller
public class IndexAdminController extends Common {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	DinnertableService dinnertableService;
	@Autowired
	TablestatusService tablestatusService;
	@Autowired
	ProductService productService;
	@Autowired
	BillService billService;
	@Autowired
	BilldetailService billdetailService;

	@GetMapping(value = { "/admin/index" })
	public String index(ModelMap modelMap, HttpSession httpSession) {

		// check logined
		if (httpSession.getAttribute("emId") == null) {
			return "redirect:/admin/login";
		}
		String emId = httpSession.getAttribute("emId").toString();
		Employee employee = employeeService.getInfoById(emId);
		modelMap.addAttribute(employee);

		// danh sách bàn

		List<indexAdminDTO> dtos = new ArrayList<indexAdminDTO>();
		List<Dinnertable> dinnertables = dinnertableService.findAll();
		for (Dinnertable dinnertable : dinnertables) {
			indexAdminDTO indexAdminDTO = new indexAdminDTO();
			indexAdminDTO.setDinnertable(dinnertable);

			dtos.add(indexAdminDTO);
		}
		modelMap.addAttribute("dtos", dtos);

		return "/admin/index";
	}

	@GetMapping(value = "/admin/index-modal")
	public String Modal(ModelMap modelMap, @RequestParam String dinnertableid, @RequestParam String startPosition,
			@RequestParam String inputSearch) {

		int IntstartPosition = Integer.valueOf(startPosition.trim()) - 1;
		if (IntstartPosition < 0) {
			IntstartPosition = 0;
		}
		if (inputSearch == "") {
			inputSearch = null;
		}

		if (dinnertableService.getInfoById(Integer.valueOf(dinnertableid.trim())) == null) {
			modelMap.addAttribute("results", "Bàn này không tồn tại!");
			return "/admin/public/Danger";
		}

		int totalPage = productService.findAll().size() / super.MAX_RESULTS;
		if ((productService.findAll().size() % super.MAX_RESULTS) > 0) {
			totalPage++;
		}
		modelMap.addAttribute("totalPage", totalPage);

		// list trạng thái bàn
		List<Tablestatus> listTablestatus = tablestatusService.findAll();
		modelMap.addAttribute("listTablestatus", listTablestatus);

		// list sản phẩm
		List<Product> products = productService.getListProductLimit(IntstartPosition, null, inputSearch, null, null,
				null, null);
		Bill bill = billService.getInfoLastBill(Integer.valueOf(dinnertableid.trim()));

		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct(product);
			if (bill != null) {
				Billdetail billdetail = billdetailService
						.getInfoBilldetailByBilldetailId(new BilldetailId(product.getProductid(), bill.getBillid()));
				if (billdetail != null) {
					int quantity = billdetail.getQuantity();
					productDTO.setQuantity(quantity);
				}
			}

			Set<Image> setImages = product.getImages();
			List<Image> images = new ArrayList<Image>();
			for (Image image : setImages) {
				images.add(image);
				productDTO.setImages(images);
				break;
			}

			productDTOs.add(productDTO);
		}
		modelMap.addAttribute("productDTOs", productDTOs);

		//
		Dinnertable dinnertable = dinnertableService.getInfoById(Integer.valueOf(dinnertableid.trim()));
		modelMap.addAttribute("dinnertable", dinnertable);

		if (bill != null) {
			modelMap.addAttribute("bill", bill);
			modelMap.addAttribute("totalPriceBill", billService.getTotalPriceOfBill(bill.getBillid()));

			List<Billdetail> billdetails = billdetailService.getInfoBilldetailByBillId(bill.getBillid());
			List<BillDetailDTO> dtos = new ArrayList<BillDetailDTO>();
			for (Billdetail billdetail : billdetails) {
				String productId = billdetail.getProduct().getProductid();

				BillDetailDTO billDetailDTO = new BillDetailDTO();
				billDetailDTO.setBilldetail(billdetail);
				billDetailDTO.setSinglePrice(
						billdetailService.getSinglePriceOfBillDetail(productId, bill.getStartdatetime()));

				billDetailDTO.setTotalPrice(
						billdetailService.getPriceOfBillDetail(new BilldetailId(productId, bill.getBillid())));

				dtos.add(billDetailDTO);
			}

			modelMap.addAttribute("dtos", dtos);
		}

		return "/admin/public/modal-index";
	}

	@PostMapping(value = "/admin/index-updateTableStatus")
	public @ResponseBody String UpdateTableStatus(ModelMap modelMap, @RequestParam String dinnertableid,
			@RequestParam String tablestatusid) {

		Dinnertable dinnertable = dinnertableService.getInfoById(Integer.valueOf(dinnertableid.trim()));
		if (dinnertable == null) {
			return "{\"nameTableStatus\":\"\", \"class\":\"badge badge-danger\",\"mes\":\"Bàn này không tồn tại!\"}";
		}

		Tablestatus tablestatus = tablestatusService.getInfoById(Integer.valueOf(tablestatusid.trim()));
		if (tablestatus == null) {
			return "{\"nameTableStatus\":\"\", \"class\":\"badge badge-danger\",\"mes\":\"Trạng thái bàn này không tồn tại!\"}";
		}

		dinnertable.setTablestatus(new Tablestatus(Integer.valueOf(tablestatusid.trim())));
		dinnertableService.editDinnertable(dinnertable);

		return "{\"nameTableStatus\":\"" + tablestatus.getName() + "\", \"class\":\"badge badge-success\",\"mes\":\"Cập nhật trạng thái bàn thành công!\"}";
	}

	@PostMapping(value = "/admin/index-updateBillDetail") // khi click nút THÊM SẢN PHẨM vào hóa đơn
	public String UpdateBillDetail(ModelMap modelMap, @RequestParam String dinnertableid,
			@RequestParam String listProduct) {

		Bill bill = billService.getInfoLastBill(Integer.valueOf(dinnertableid.trim()));
		int lastBillId;
		if (bill == null) {// kiểm tra bill có sẵn chưa -> chưa thì thêm
			bill = new Bill();
//			bill.setEmployee(employee);
			bill.setBillstatus(new Billstatus("CTT"));
			bill.setDinnertable(new Dinnertable(Integer.valueOf(dinnertableid.trim())));
			bill.setStartdatetime(new Date());
			bill.setUpdateat(new Date());
			bill.setIsdelete(IS_NOT_DELETE);
			lastBillId = billService.addBill(bill);
		} else {
			lastBillId = bill.getBillid();
		}

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode jsonObject = objectMapper.readTree(listProduct);
			JsonNode jsonArray = jsonObject.get("listProduct");

			String productid;
			int quantity;
			for (JsonNode product : jsonArray) {
				productid = product.get("productid").asText();
				quantity = product.get("quantity").asInt();
				/* check */
				if (productService.getInfoById(productid) == null) {
					modelMap.addAttribute("results", "Sản phẩm này không tồn tại!");
					return "/admin/public/Danger";
				}
				if (quantity < 0) {
					modelMap.addAttribute("results", "Số lượng không đúng!");
					return "/admin/public/Danger";
				}
				/* check[END] */

				if (quantity > 0) {
					Billdetail billdetail = billdetailService
							.getInfoBilldetailByBilldetailId(new BilldetailId(productid, lastBillId));
					if (billdetail == null) {
						// chưa có -> thêm mới
						billdetail = new Billdetail();
						billdetail.setId(new BilldetailId(productid, lastBillId));
						billdetail.setQuantity(quantity);
						billdetail.setUpdateat(new Date());
						billdetail.setIsdelete(IS_NOT_DELETE);
						billdetailService.addBilldetail(billdetail);
					} else {
						billdetail.setQuantity(quantity);
						billdetail.setUpdateat(new Date());
						billdetailService.editBilldetail(billdetail);

					}
				}
			}

		} catch (Exception e) {
			modelMap.addAttribute("results", "Lỗi bất ngờ!");
			return "/admin/public/Danger";
		}
		modelMap.addAttribute("result", "Cập nhật thành công!");
		return "/admin/public/Success";
	}

	@PostMapping(value = "/admin/index-updateBillStatus")
	public String UpdateBillStatus(ModelMap modelMap, @RequestParam String billid) {

		Bill bill = billService.getInfoById(Integer.valueOf(billid.trim()));
		if (bill == null) {
			modelMap.addAttribute("results", "Hoá đơn này không tồn tại!");
			return "/admin/public/Danger";
		}

		bill.setUpdateat(new Date());
		bill.setBillstatus(new Billstatus("DTT"));
		bill.setEnddate(new Date());
		bill.setUpdateat(new Date());
		billService.editBill(bill);

		modelMap.addAttribute("result", "Thanh toán thành công!");
		return "/admin/public/Success"; // thành công
	}

	@PostMapping(value = "/admin/index-updateBill") // khi click nút LƯU CHỈNH SỬA hóa đơn
	public String UpdateBill(ModelMap modelMap, @RequestParam String billid, @RequestParam String listProduct) {

		Bill bill = billService.getInfoById(Integer.valueOf(billid.trim()));
		if (bill == null) {
			modelMap.addAttribute("results", "Hoá đơn này không tồn tại!");
			return "/admin/public/Danger";
		}

		// cập nhật bill detail cũ
		List<Billdetail> billdetails = billdetailService.getInfoBilldetailByBillId(Integer.valueOf(billid.trim()));
		for (Billdetail billdetail : billdetails) {

			if (listProduct.indexOf(billdetail.getId().getProductid()) == -1) {// không có trong list product - > xóa
				billdetail.setUpdateat(new Date());
				billdetail.setIsdelete(IS_DELETE);
				billdetailService.editBilldetail(billdetail);
			}
		}

		modelMap.addAttribute("result", "Chỉnh sửa hóa đơn thành công!");
		return "/admin/public/Success";
	}

}
