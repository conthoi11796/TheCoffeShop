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
public class ProductController extends Common {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryProductService categoryProductService;

	@GetMapping(value = "/admin/product")
	public String index(ModelMap modelMap, HttpSession httpSession) {

		List<Categoryproduct> categoryproducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryproducts", categoryproducts);

		return "/admin/product";
	}

	@GetMapping(value = "/admin/product/table")
	public String tbody(ModelMap modelMap, HttpSession httpSession) {

		List<Product> products = productService.findAll();
		modelMap.addAttribute("products", products);

		return "/admin/content/product/tBody";
	}

	@PostMapping(value = "/admin/product/insert")
	public String insert(ModelMap modelMap, HttpSession httpSession, @RequestParam String productid,
			@RequestParam String name, @RequestParam String description, @RequestParam String categoryproductid) {

		if (productService.getInfoById(productid.trim()) != null) {

			modelMap.addAttribute("result", "Mã sản phẩm bị trùng!");
			return "/admin/public/Danger";// đã tồn tại
		}
		if (productService.checkExistNameProduct(name.trim())) {

			modelMap.addAttribute("result", "Tên sản phẩm bị trùng!");
			return "/admin/public/Danger";// đã tồn tại
		}
		if (categoryproductid == "-1") {

			modelMap.addAttribute("result", "Chưa chọn loại sản phẩm!");
			return "/admin/public/Danger";// đã tồn tại
		}

		Product product = new Product();
		product.setProductid(productid.trim());
		product.setName(name);
		product.setDescription(description);
		Categoryproduct categoryproduct = categoryProductService.getInfoById(categoryproductid);
		product.setCategoryproduct(categoryproduct);
		product.setCreateat(new Date());
//		product.setCreateby(createby);
		product.setUpdateat(new Date());
		productService.addProduct(product);

		List<Categoryproduct> categoryproducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryproducts", categoryproducts);

		modelMap.addAttribute("result", "Thêm thành công!");
		return "/admin/public/Success"; // thành công
	}

	@PostMapping(value = "/admin/product/remove")
	public String remove(ModelMap modelMap, HttpSession httpSession, @RequestParam String productid) {

		Product product = productService.getInfoById(productid.trim());
		if (product == null) {
			modelMap.addAttribute("result", "Sản phẩm không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}
		product.setIsdelete(this.IS_DELETE);
		product.setUpdateat(new Date());
		productService.editProduct(product);

		modelMap.addAttribute("result", "Xóa thành công!");
		return "/admin/public/Success";// đã tồn tại
	}

	@GetMapping(value = "/admin/product/edit")
	public String view(ModelMap modelMap, HttpSession httpSession, @RequestParam String productid) {

		List<Categoryproduct> categoryproducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryproducts", categoryproducts);
		
		Product product = productService.getInfoById(productid.trim());
		if (product == null) {
			modelMap.addAttribute("result", "Sản phẩm không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		modelMap.addAttribute("product", product);
		return "/admin/content/product/form";
	}

	@PostMapping(value = "/admin/product/edit")
	public String edit(ModelMap modelMap, HttpSession httpSession, @RequestParam String productid,
			@RequestParam String name, @RequestParam String description, @RequestParam String categoryproductid) {

		Product product = productService.getInfoById(productid.trim());
		if (product == null) {
			modelMap.addAttribute("result", "Sản phẩm không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}
		if (productService.checkExistNameProduct(name.trim())) {

			modelMap.addAttribute("result", "Tên sản phẩm bị trùng!");
			return "/admin/public/Danger";// đã tồn tại
		}

		product.setName(name);
		product.setDescription(description.trim());
		Categoryproduct categoryproduct = categoryProductService.getInfoById(categoryproductid);
		product.setCategoryproduct(categoryproduct);
//		product.setUpdateby(updateby);
		product.setUpdateat(new Date());
		productService.editProduct(product);

		modelMap.addAttribute("result", "Cập nhật thành công!");
		return "/admin/public/Success";
	}
}
