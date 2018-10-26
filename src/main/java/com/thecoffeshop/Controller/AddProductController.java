package com.thecoffeshop.Controller;

import java.security.MessageDigest;
import java.sql.Array;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thecoffeshop.Models.Categoryproduct;
import com.thecoffeshop.Service.CategoryProductService;

@Controller
@RequestMapping(value = "/admin")
public class AddProductController {

	@Autowired
	private CategoryProductService categoryProductService;

	@GetMapping(value = { "/add-product" })
	public String index(HttpSession httpSession, ModelMap modelMap) {

		// check logined
		if (this.checkLogIn(httpSession) != null) {
			return this.checkLogIn(httpSession);
		}
		
		List<Categoryproduct> categoryproducts = categoryProductService.findAll();

		modelMap.addAttribute("categoryproducts", categoryproducts);
		if (categoryproducts != null) {
			modelMap.addAttribute(categoryproducts);
		}

		return "/admin/add-product";

	}

	@PostMapping(value = { "/add-product" })
//	public @ResponseBody String index(@RequestParam PId,HttpSession httpSession, ModelMap modelMap) {
//
//		// check logined
//		if (this.checkLogIn(httpSession) != null) {
//			return this.checkLogIn(httpSession);
//		}
//
//		return PId;

//	}

	/** check logined */
	public String checkLogIn(HttpSession httpSession) {
		if (httpSession.getAttribute("emId") == null) {
			// has a session emId
			return "redirect:/admin/login";
		}
		return null;
	}

	/** Create PId */
	@GetMapping(value = "/add-product/createPId")
	public @ResponseBody String createPId(@RequestParam String PName, Model model) {

		// stringleght default = 4
		String PId = PName.substring(0, PName.length() >= 4 ? 4 : PName.length());
		// stringleght default 3
		int number;
		// if PName.lenght() >= 4 -> stringleght default = 3. Because total must
		// PId.lenght =7
		if (PId.length() >= 4) {
			number = 1000;
		}
		// if PName < 4 -> stringleght default = 7 - PName.lenght(). Because total must
		// PId.lenght =7
		else {
			int k = 7 - PName.length();
			String strTemb = "1";
			for (int i = 0; i < k; i++) {
				strTemb += "0";
			}
			number = Integer.parseInt(strTemb);
		}
		int intRanDom = new Random().nextInt(number);
		// total stringleght = 7
		PId = PId + Integer.toString(intRanDom);

		return PId;
	}
}
