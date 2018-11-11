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
public class CategoryProductDAOController extends Common {

	@Autowired
	CategoryProductService categoryProductService;

	@GetMapping(value = "/admin/category-product")
	public String index(ModelMap modelMap, HttpSession httpSession) {

		return "/admin/category-product";
	}

	@GetMapping(value = "/admin/category-product/table")
	public String tbody(ModelMap modelMap, HttpSession httpSession) {

		List<Categoryproduct> categoryproducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryproducts", categoryproducts);

		return "/admin/content/category-product/tBody";
	}

	@PostMapping(value = "/admin/category-product/insert")
	public String insert(ModelMap modelMap, HttpSession httpSession, @RequestParam String categoryproductid,
			@RequestParam String name) {

		if (categoryProductService.getInfoById(categoryproductid.trim()) != null) {

			modelMap.addAttribute("result", "Mã đã tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		Categoryproduct categoryproduct = new Categoryproduct();
		categoryproduct.setCategoryproductid(categoryproductid);
		categoryproduct.setName(name);
//		categoryproduct.setCreateby(createby);
		categoryproduct.setCreateat(new Date());
		categoryproduct.setUpdateat(new Date());
		categoryproduct.setIsdelete(super.IS_NOT_DELETE);
		categoryProductService.addCategoryProduct(categoryproduct);

		List<Categoryproduct> categoryproducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryproducts", categoryproducts);

		modelMap.addAttribute("result", "Thêm thành công!");
		return "/admin/public/Success"; // thành công
	}

	@PostMapping(value = "/admin/category-product/remove")
	public String remove(ModelMap modelMap, HttpSession httpSession, @RequestParam String categoryproductid) {

		Categoryproduct categoryproduct = categoryProductService.getInfoById(categoryproductid.trim());
		if (categoryproduct == null) {
			modelMap.addAttribute("result", "Loại sản phẩm không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}
		categoryproduct.setIsdelete(this.IS_DELETE);
		categoryProductService.editCategoryproduct(categoryproduct);

		modelMap.addAttribute("result", "Xóa thành công!");
		return "/admin/public/Success";// đã tồn tại
	}

	@GetMapping(value = "/admin/category-product/edit")
	public String view(ModelMap modelMap, HttpSession httpSession, @RequestParam String categoryproductid) {

		Categoryproduct categoryproduct = categoryProductService.getInfoById(categoryproductid.trim());
		if (categoryproduct == null) {
			modelMap.addAttribute("result", "Loại sản phẩm không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		modelMap.addAttribute("categoryproduct", categoryproduct);
		return "/admin/content/category-product/form";
	}

	@PostMapping(value = "/admin/category-product/edit")
	public String edit(ModelMap modelMap, HttpSession httpSession, @RequestParam String categoryproductid,
			@RequestParam String name) {

		Categoryproduct categoryproduct = categoryProductService.getInfoById(categoryproductid.trim());
		if (categoryproduct == null) {
			modelMap.addAttribute("result", "Trạng thái hóa đơn không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		categoryproduct.setName(name);
		categoryProductService.editCategoryproduct(categoryproduct);

		modelMap.addAttribute("result", "Cập nhật thành công!");
		return "/admin/public/Success";
	}
}
