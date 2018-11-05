package com.thecoffeshop.Controller;

import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.thecoffeshop.Models.Bill;
import com.thecoffeshop.Models.Categoryproduct;
import com.thecoffeshop.Models.Customer;
import com.thecoffeshop.Models.Image;
import com.thecoffeshop.Models.Product;
import com.thecoffeshop.Models.Voucher;
import com.thecoffeshop.Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.thecoffeshop.DTO.*;

@Controller
public class UserOrderProductController extends Common {

	@Autowired
	CategoryProductService categoryProductService;
	@Autowired
	ProductService productService;
	@Autowired
	PriceService priceService;
	@Autowired
	VoucherService voucherService;
	@Autowired
	CustomerService customerService;

	@GetMapping(value = "/order-product", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String index(ModelMap modelMap, HttpSession httpSession, @RequestParam String listCart,
			@RequestParam String listNumberProduct) {

		/* display Categoryproduct on combobox */
		List<Categoryproduct> categoryProducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryProducts", categoryProducts);

		String listPId = listCart;
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		while ((listPId.indexOf(",") != -1) && (listNumberProduct.indexOf(",") != -1)) {
			String PId = listPId.substring(0, listPId.indexOf(","));
			int number = Integer.valueOf(listNumberProduct.substring(0, listNumberProduct.indexOf(",")));

			Product product = productService.getInfoById(PId);
			if (product != null) {
				try {
					ProductDTO productDTO = new ProductDTO();
					productDTO.setProduct(product);
					List<Image> images = new ArrayList<Image>();
					if (product.getImages().size() > 0) {
						Set<Image> setImages = product.getImages();
						for (Image image : setImages) {
							images.add(image);
						}
						productDTO.setImages(images);
					}
					productDTO.setNumber(number);
					productDTO.setPrice(priceService.getOldPrice(product.getPId()));

					productDTOs.add(productDTO);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			listPId = listPId.substring(listPId.indexOf(",") + 1, listPId.length());
			listNumberProduct = listNumberProduct.substring(listNumberProduct.indexOf(",") + 1,
					listNumberProduct.length());
		}
		modelMap.addAttribute("productDTOs", productDTOs);

		return "/user/orderProduct";
	}

	@PostMapping(value = "/order-product", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String orderProduct(ModelMap modelMap, HttpSession httpSession, @RequestParam String cuName,
			@RequestParam String cuAddress, @RequestParam String cuPhoneNumber, @RequestParam String biDatetimeStart,
			@RequestParam String biNotice, @RequestParam String voId) {

		if (voId != null && !voucherService.checkVoucher(voId)) {

		}

		Customer customer = new Customer();
		customer.setCuName(cuName);
		customer.setCuAddress(cuAddress);
		customer.setCuPhoneNumber(cuPhoneNumber);
		customer.setIsDelete(super.IS_NOT_DELETE);

		System.out.println(customerService.addCustomer(customer)+"--------------------------------------------------");
		
		Bill bill = new Bill();
		Date DatetimeStart = null;
		try {
			DatetimeStart = super.sdf.parse(biDatetimeStart);
		} catch (Exception e) {
		}
		bill.setBiDatetimeStart(DatetimeStart);
		bill.setBiNotice(biNotice);
		bill.setVoucher(new Voucher(voId));

		return "/user/orderProduct";
	}
}
