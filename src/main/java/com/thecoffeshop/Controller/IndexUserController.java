package com.thecoffeshop.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thecoffeshop.Models.Categoryproduct;
import com.thecoffeshop.Models.Image;
import com.thecoffeshop.Models.Price;
import com.thecoffeshop.Models.Product;
import com.thecoffeshop.Service.CategoryProductService;
import com.thecoffeshop.Service.Common;
import com.thecoffeshop.Service.ImageService;
import com.thecoffeshop.Service.PriceService;
import com.thecoffeshop.Service.ProductService;
import com.thecoffeshop.DTO.*;

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
			strSearch = null;
		}
		pagination(modelMap, httpSession, startPosition, cgPrdId, strSearch);

		return "/user/index";

	}

	/* get info of product */
	@PostMapping(value = "/infoProduct", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String infoProduct(@RequestParam String productid, ModelMap modelMap) {

		System.out.println(productid);
		
		Product product = productService.getInfoById(productid);

		if (product == null) {
			return "Sản phẩm không tồn tại";
		}

		modelMap.addAttribute("product", product);
		modelMap.addAttribute("old_prPrice", priceService.getOldPrice(product.getProductid()));
		Price new_Price = priceService.getNewPrice(product.getProductid());
		if (new_Price != null) {
			modelMap.addAttribute("new_Price", new_Price);
		}
		Set<Image> images = product.getImages();
		modelMap.addAttribute("images", images);

		return "/user/infoProduct";
	}

	public void pagination(ModelMap modelMap, HttpSession httpSession, int startPosition, String cgPrdId,
			String strSearch) {

		modelMap.addAttribute("startPosition", startPosition + 1);
		modelMap.addAttribute("cgPrdId", cgPrdId);

		/* display Categoryproduct on combobox */
		List<Categoryproduct> categoryProducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryProducts", categoryProducts);

		/* display list product on page */
		List<Product> products = productService.getListProductLimit(startPosition, cgPrdId, strSearch);

		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		/* display price product and sale price and new product release */
		for (Product product : products) {

			ProductDTO productDTO = new ProductDTO();

			/* find old price */
			productDTO.setProduct(product);

			float oldPrice = priceService.getOldPrice(product.getProductid());
			if (oldPrice > 0) {
				productDTO.setPrice((int) oldPrice);
			}

			/* find new price */
			Price newPrice = priceService.getNewPrice(product.getProductid());
			if (newPrice != null) {

				/* new price */
				productDTO.setNewPrice(newPrice);
				/* rate price between new price to old price */
				float newPriceValue = newPrice.getPrice();

				int rate = this.rateOldAndNewPrice(oldPrice, newPriceValue);
				productDTO.setRateOldAndNewPrice(rate);
			}

			/* check is new product */
			productDTO.setCheckIsNew(false);
			if (productService.checkIsNewProduct(product.getProductid())) {
				productDTO.setCheckIsNew(true);
			}
			
			productDTOs.add(productDTO);
		}
		modelMap.addAttribute("productDTOs", productDTOs);
	}
}
