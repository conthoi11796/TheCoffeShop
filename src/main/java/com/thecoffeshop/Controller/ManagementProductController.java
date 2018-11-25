package com.thecoffeshop.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thecoffeshop.Service.*;
import com.thecoffeshop.DTO.ProductDTO;
import com.thecoffeshop.Models.*;

@Controller
public class ManagementProductController {

	@Autowired
	ProductService productService;
	@Autowired
	ExportbillService exportbillService;
	@Autowired
	CategoryProductService categoryProductService;

	@GetMapping(value = "/admin/warehouse-product")
	public String index(ModelMap modelMap) {

		List<Categoryproduct> categoryProducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryProducts", categoryProducts);

		List<Product> products = productService.getListProductLimit(0, null, null, null, null, null, null);

		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct(product);

			Set<Image> setImages = product.getImages();
			List<Image> images = new ArrayList<Image>();
			for (Image image : setImages) {
				images.add(image);
				productDTO.setImages(images);
				break;
			}

			productDTO.setQuantity(exportbillService.totalQuantityProduct(product.getProductid()));

			dtos.add(productDTO);
		}

		modelMap.addAttribute("dtos", dtos);

		return "/admin/management-warehouse/product";
	}

	@PostMapping(value = "/admin/warehouse-product")
	public String search(ModelMap modelMap, @RequestParam String categoryproductid, @RequestParam String productid,
			@RequestParam String name) {

		if (categoryproductid.trim().length() <= 0) {
			categoryproductid = null;
		}
		if (productid.trim().length() <= 0) {
			productid = null;
		}
		if (name.trim().length() <= 0) {
			name = null;
		}
		List<Categoryproduct> categoryProducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryProducts", categoryProducts);
		List<Product> products = productService.getListProductLimit(0, categoryproductid, name, null, null, null, productid);

		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct(product);

			Set<Image> setImages = product.getImages();
			List<Image> images = new ArrayList<Image>();
			for (Image image : setImages) {
				images.add(image);
				productDTO.setImages(images);
				break;
			}

			productDTO.setQuantity(exportbillService.totalQuantityProduct(product.getProductid()));

			dtos.add(productDTO);
		}

		modelMap.addAttribute("dtos", dtos);

		return "/admin/management-warehouse/content/product/content";
	}

	@PostMapping(value = "/admin/warehouse-product/update")
	public @ResponseBody String updateQuantity(ModelMap modelMap, @RequestParam String productid,
			@RequestParam String quantity) {

		if (quantity.trim().length() <= 0 || Integer.valueOf(quantity.trim()) <= 0) {
			return "{\"id\":\"0\",\"mes\":\"Số lượng để trống và nhỏ hơn không!\"}";
		}

		Product product = productService.getInfoById(productid.trim());
		if (product == null) {
			return "{\"id\":\"0\",\"mes\":\"Sản phẩm không tồn tại!\"}";
		}
		if (Integer.valueOf(quantity.trim()) > exportbillService.totalQuantityProduct(productid.trim())) {
			return "{\"id\":\"0\",\"mes\":\"Số lượng bỏ phải <= số lượng tồn!\"}";
		}

		int intQuality = Integer.valueOf(quantity.trim());
		List<Exportbill> exportbills = exportbillService.getListExportBillbyProduct(productid);
		for (Exportbill exportbill : exportbills) {

			// số nhập nhỏ hơn số lượng đang có
			if ((exportbill.getQuantity() - intQuality) >= 0) {
				exportbill.setQuantity(exportbill.getQuantity() - intQuality);
				exportbillService.editExportbill(exportbill);
			}
			// số nhập lớn hơn số lượng đang có
			if ((exportbill.getQuantity() - intQuality) < 0) {
				exportbill.setQuantity(0);
				exportbillService.editExportbill(exportbill);
				intQuality = intQuality - exportbill.getQuantity();
			}
		}

		int totalQuantity = exportbillService.totalQuantityProduct(product.getProductid());
		return "{\"id\":\"1\",\"mes\":\"Cập nhật thành công!\",\"quantity\":\"" + totalQuantity + "\"}";
	}
}
