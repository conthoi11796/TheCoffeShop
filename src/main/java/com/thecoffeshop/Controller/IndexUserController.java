package com.thecoffeshop.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thecoffeshop.Models.Categoryproduct;
import com.thecoffeshop.Models.Image;
import com.thecoffeshop.Models.Price;
import com.thecoffeshop.Models.Product;
import com.thecoffeshop.Service.CategoryProductService;
import com.thecoffeshop.Service.Common;
import com.thecoffeshop.Service.ImageService;
import com.thecoffeshop.Service.PriceService;
import com.thecoffeshop.Service.ProductService;

@Controller
public class IndexUserController extends Common {

	@Autowired
	private CategoryProductService categoryProductService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PriceService priceService;
	@Autowired
	private ImageService imageService;

	@GetMapping(value = "/index", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String index(ModelMap modelMap, HttpSession httpSession) {

		pagination(modelMap, httpSession, 0, null, null);

		return "/user/index";

	}

	@GetMapping(value = "/index/search", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String index2(ModelMap modelMap, HttpSession httpSession, @RequestParam String page,
			@RequestParam String cgPrdId, @RequestParam String strSearch) {

		int startPosition = 0;
		if (page != "") {
			startPosition = Integer.valueOf(page);
		}
		if (cgPrdId == "") {
			cgPrdId = null;
		}
		if (strSearch == "") {
			strSearch= null;
		}
		System.out.println(page + cgPrdId + strSearch);
		pagination(modelMap, httpSession, startPosition, cgPrdId, strSearch);

		return "/user/index";

	}

	/* get info of product */
	@PostMapping(value = "/infoProduct", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String infoProduct(@RequestParam String PId, ModelMap modelMap) {

		Product product = productService.getInfoById(PId);

		if (product == null) {
			return "Sản phẩm không tồn tại";
		}

		modelMap.addAttribute("product", product);
		modelMap.addAttribute("old_prPrice", priceService.getOldPrice(product.getPId()));
		Price new_Price = priceService.getNewPrice(product.getPId());
		if (new_Price != null) {
			modelMap.addAttribute("new_Price", new_Price);
		}
		Set<Image> images = product.getImages();
		modelMap.addAttribute("images", images);

		return "/user/infoProduct";
	}

	public void pagination(ModelMap modelMap, HttpSession httpSession, int startPosition, String cgPrdId,
			String strSearch) {

		modelMap.addAttribute("startPosition",startPosition + 1);
		modelMap.addAttribute("cgPrdId", cgPrdId);
		
		/* display Categoryproduct on combobox */
		List<Categoryproduct> categoryProducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryProducts", categoryProducts);

		/* display list product on page */
		List<Product> products = productService.getListProductLimit(startPosition, cgPrdId, strSearch);
		modelMap.addAttribute("products", products);
		
		/* display price product and sale price and new product release */
		String priceProducts[][] = new String[products.size()][6];
		int i = 0;
		for (Product product : products) {

			/* find old price */
			priceProducts[i][0] = product.getPId();

			float oldPrice = priceService.getOldPrice(product.getPId());
			if (oldPrice > 0) {
				priceProducts[i][1] = String.valueOf((int) oldPrice) + "đ";
			}

			/* find new price */
			Price price = priceService.getNewPrice(product.getPId());
			if (price != null) {

				/* new price */
				priceProducts[i][2] = String.valueOf(price.getPrPrice()) + "đ";

				/* date apply */
				priceProducts[i][3] = String.valueOf(super.sdf.format(price.getPrDatestart()));

				/* rate price between new price to old price */
				float newPrice = price.getPrPrice();

				int rate = this.rateOldAndNewPrice(oldPrice, newPrice);
				if (rate > 0) {
					priceProducts[i][4] = "-" + String.valueOf(rate) + "%";// sale
				}
			}

			/* check is new product */
			priceProducts[i][5] = "0";// old product
			if (productService.checkIsNewProduct(product.getPId())) {
				priceProducts[i][5] = "1";// is new product
			}
			i++;
		}
		modelMap.addAttribute("priceProducts", priceProducts);
	}
}
