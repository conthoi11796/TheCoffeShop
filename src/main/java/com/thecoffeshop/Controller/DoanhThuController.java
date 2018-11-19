package com.thecoffeshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.thecoffeshop.Service.Common;

@Controller
public class DoanhThuController extends Common {

	@GetMapping(value = "/admin/doanh-thu")
	public String index() {
		
		return "/admin/statistic/doanh-thu";
	}
}
