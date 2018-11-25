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
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping(value = "/index")
	public String index(ModelMap modelMap, HttpSession httpSession) {

		pagination(modelMap, httpSession, 0, null, null, null, null, null);

		return "/user/index";

	}

	@PostMapping(value = "/index/search")
	public String search(ModelMap modelMap, HttpSession httpSession, @RequestParam String page,
			@RequestParam String cgPrdId, @RequestParam String strSearch, @RequestParam String isHotDeal,
			@RequestParam String priceAZ, @RequestParam String priceZA) {

		int startPosition = Integer.valueOf(page.trim());
		// pagination(modelMap, httpSession, startPosition, cgPrdId, strSearch,
		// isHotDeal, priceAZ, priceZA);
		pagination(modelMap, httpSession, startPosition, cgPrdId, strSearch.trim(), null, null, null);
		return "user/content/content-index";

	}

	/* get info of product */
	@PostMapping(value = "/infoProduct")
	public String infoProduct(@RequestParam String productid, ModelMap modelMap) {

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

		return "/user/content/infoProduct";
	}

	public void pagination(ModelMap modelMap, HttpSession httpSession, int startPosition, String cgPrdId,
			String strSearch, String isHotDeal, String priceAZ, String priceZA) {

		modelMap.addAttribute("startPosition", startPosition + 1);
		modelMap.addAttribute("cgPrdId", cgPrdId);
		modelMap.addAttribute("strSearch", strSearch);
		modelMap.addAttribute("isHotDeal", isHotDeal);
		modelMap.addAttribute("priceAZ", priceAZ);
		modelMap.addAttribute("priceZA", priceZA);

		/* display Categoryproduct on combobox */
		List<Categoryproduct> categoryProducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryProducts", categoryProducts);

		/* display list product on page */
		if (cgPrdId != null && cgPrdId.equals("-1")) {
			cgPrdId = null;
		}
		if(strSearch == "") {
			strSearch = null;
		}

		List<Product> products = productService.getListProductLimit(startPosition, cgPrdId, strSearch, isHotDeal,
				priceAZ, priceZA, null);

		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		/* display price product and sale price and new product release */
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();

			/* image */
			Set<Image> setImages = product.getImages();
			List<Image> images = new ArrayList<Image>();
			int size = setImages.size() - 1;
			for (Image image : setImages) {
				if (size <= 3) {
					images.add(image);
				}
				size--;
			}
			productDTO.setImages(images);

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
