package com.thecoffeshop.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.thecoffeshop.Common;
import com.thecoffeshop.Models.Categoryproduct;
import com.thecoffeshop.Models.Price;
import com.thecoffeshop.Models.Product;
import com.thecoffeshop.Service.CategoryProductService;
import com.thecoffeshop.Service.PriceService;
import com.thecoffeshop.Service.ProductService;

@Controller
@RequestMapping(value = "/admin")
public class AddProductController extends Common {

	@Autowired
	private CategoryProductService categoryProductService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PriceService priceService;

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

	/**
	 * add product
	 * 
	 * @throws JsonProcessingException
	 */
	@PostMapping(value = { "/add-product" })
	public @ResponseBody String index(@RequestParam String FormData, HttpSession httpSession, ModelMap modelMap)
			throws ParseException, JsonProcessingException {
		System.out.println("-------Form Data: " + FormData);
		JsonObject jsonResult = new JsonObject();
		// FormData%3DPId%3Dcxzz49%26PName%3Dcxz%26PDescription%3D%26prPrice%3D123%26prDatestart%3D2018-10-10%26cgPrdId%3D127
		/* AVANCES REST API */
//		FormData = FormData.substring(9, FormData.length());
//		System.out.println("-------Form Data: " + FormData);

		// check logined
		if (this.checkLogIn(httpSession) != null) {
			return this.checkLogIn(httpSession);
		}

		// Convert FormData to JsonObject
		JsonObject objFormData = this.convertStringToJson(FormData);

		Product product = new Product();
		product.setPId(this.getValueJsonObject(objFormData, "PId"));
		product.setPName(this.getValueJsonObject(objFormData, "PName"));
		product.setPDescription(this.getValueJsonObject(objFormData, "PDescription"));
		// product.setCreateBy(httpSession.getAttribute("emId").toString());
		product.setCreateAt(new Date());
		product.setIsDelete(productService.IS_NOT_DELETE);
		product.setCategoryproduct(new Categoryproduct(this.getValueJsonObject(objFormData, "cgPrdId")));

		if (productService.addProduct(product)) {
			Price price = new Price();
			price.setProduct(product);
			Date PrDatestart = null;
			try {
				PrDatestart = new SimpleDateFormat("yyyy-MM-dd")
						.parse(this.getValueJsonObject(objFormData, "prDatestart"));
			} catch (Exception e) {
			}
			price.setPrPrice(Integer.valueOf(this.getValueJsonObject(objFormData, "prPrice")));
			price.setPrDatestart(PrDatestart);
//			price.setCreateBy(httpSession.getAttribute("emId").toString());
			price.setCreateAt(new Date());
			price.setIsDelete(priceService.IS_NOT_DELETE);

			if (priceService.addPrice(price)) {
				Product productNew = productService.getInfoById(product.getPId());

				String categoryproductcg_PrdName = productNew.getCategoryproduct().getCgPrdName();
				String pricespr_Price = priceService.getInfoByProduct(productNew.getPId()).getPrPrice().toString();
				String pricespr_Datestart = priceService.getInfoByProduct(productNew.getPId()).getPrDatestart()
						.toString();
				productNew.setCategoryproduct(null);
				productNew.setBilldetails(null);
				productNew.setExportbills(null);
				productNew.setImages(null);
				productNew.setPrices(null);

				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString(productNew);
//				System.out.println("-------JSon object result: "+jsonString);
//				{"categoryproduct":null,"createBy":null}
				System.out.println("-------JSon object result: " + jsonString);
				jsonResult = this.convertStringToJson(jsonString);
				jsonResult.addProperty("cgPrdName", categoryproductcg_PrdName);
				jsonResult.addProperty("prPrice", pricespr_Price);
				jsonResult.addProperty("prDatestart", pricespr_Datestart);
				jsonResult.addProperty("success", "Thêm sản phẩm thành công!");

			} else {
				jsonResult.addProperty("warning", "Lỗi thêm giá sản phẩm!");
			}
		} else {
			jsonResult.addProperty("warning", "Lỗi không thể thêm sản phẩm!");
		}

		return jsonResult.toString();

	}

	/**
	 * Create PId
	 */
	@GetMapping(value = "/add-product/createPId")
	public @ResponseBody String createPId(@RequestParam String PName, Model model) {
		// System.out.println("--------PName: " + PName);

		if (PName == "") {
			return null;
		}

		PName = PName.trim();
		while (PName.indexOf(' ') != -1) {
			PName = PName.substring(0, PName.indexOf(' ')) + PName.substring(PName.indexOf(' '), PName.length() - 1);
		}

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
