package com.thecoffeshop.Controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.thecoffeshop.Models.Categoryproduct;
import com.thecoffeshop.Models.Price;
import com.thecoffeshop.Models.Product;
import com.thecoffeshop.Service.Common;
import com.thecoffeshop.Service.*;

@Controller
public class IndexUserController extends Common {

	@Autowired
	private CategoryProductService categoryProductService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PriceService priceService;

	@GetMapping(value = "/index", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String index(ModelMap modelMap, HttpSession httpSession) {

		pagination(modelMap, httpSession, 0, null, null);

		return "/user/index";

	}

	/* pagination */
	@GetMapping(value = "/index?", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String index2(ModelMap modelMap, HttpSession httpSession, @RequestParam int page,
			@RequestParam String cgPrdId, @RequestParam String strSearch) {
		System.out.println(page);
		pagination(modelMap, httpSession, page, cgPrdId, strSearch);

		return "/user/index";

	}

	/* get info of product */
	@GetMapping(value = "/infoProduct", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String infoProduct(ModelMap modelMap, HttpSession httpSession, @RequestParam String PId) {

		Product product = productService.getInfoById(PId);

		if (product == null) {
			return "Sản phẩm không tồn tại";
		}

		System.out.println(super.convertObjectToJsonString(product));

		return "";
	}

	public void pagination(ModelMap modelMap, HttpSession httpSession, int startPosition, String cgPrdId,
			String strSearch) {

		List<Categoryproduct> categoryProducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryProducts", categoryProducts);

		List<Product> products = productService.getListProductLimit(startPosition, cgPrdId, strSearch);
		modelMap.addAttribute("products", products);

		String priceProducts[][] = new String[products.size()][6];
		int i = 0;
		for (Product product : products) {

			/* old price */
			priceProducts[i][0] = product.getPId();
			priceProducts[i][1] = String.valueOf(priceService.getOldPrice(product.getPId()));

			Price price = priceService.getNewPrice(product.getPId());
			if (price != null) {

				/* new price */
				priceProducts[i][2] = String.valueOf(price.getPrPrice());

				/* date apply */
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				priceProducts[i][3] = String.valueOf(sdf.format(price.getPrDatestart()));

				/* rate price between new price to old price */
				if (price.getPrPrice() < priceService.getOldPrice(product.getPId())) {

					float oldPrice = priceService.getOldPrice(product.getPId());
					float newPrice = price.getPrPrice();
					float result = (oldPrice - newPrice) / oldPrice * 100;

					priceProducts[i][4] = String.valueOf((int) result);
				}
			}

			/* check is new product */
			priceProducts[i][5] = "0";
			if (productService.checkIsNewProduct(product.getPId())) {
				priceProducts[i][5] = "1";
			}
			i++;
		}
		modelMap.addAttribute("priceProducts", priceProducts);
	}
}
