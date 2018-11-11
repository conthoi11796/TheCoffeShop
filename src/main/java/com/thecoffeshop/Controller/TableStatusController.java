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
import com.thecoffeshop.DTO.TableStatusDTO;
import com.thecoffeshop.Models.Tablestatus;
import com.thecoffeshop.Service.Common;
import com.thecoffeshop.Service.TablestatusService;

@Controller
public class TableStatusController extends Common {

	@Autowired
	TablestatusService tablestatusService;

	@GetMapping(value = "/admin/table-status")
	public String index(ModelMap modelMap, HttpSession httpSession) {

		return "/admin/table-status";
	}

	@GetMapping(value = "/admin/table-status/table")
	public String tbody(ModelMap modelMap, HttpSession httpSession) {

		List<Tablestatus> listTablestatus = tablestatusService.findAll();
		modelMap.addAttribute("listTablestatus", listTablestatus);

		return "/admin/content/table-status/tBody";
	}

	@PostMapping(value = "/admin/table-status/insert")
	public String insert(ModelMap modelMap, HttpSession httpSession, @RequestParam String name) {

		if (tablestatusService.checkExist(name.trim())) {

			modelMap.addAttribute("result", "Trạng thái bàn đã tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		Tablestatus tablestatus = new Tablestatus();
		tablestatus.setName(name.trim());
//		tablestatus.setCreateby(createby);
		tablestatus.setCreateat(new Date());
		tablestatus.setUpdateat(new Date());
		tablestatus.setIsdelete(this.IS_NOT_DELETE);
		tablestatusService.addTablestatus(tablestatus);

		List<Tablestatus> listTablestatus = tablestatusService.findAll();
		modelMap.addAttribute("listTablestatus", listTablestatus);

		modelMap.addAttribute("result", "Thêm thành công!");
		return "/admin/public/Success"; // thành công
	}

	@PostMapping(value = "/admin/table-status/remove")
	public String remove(ModelMap modelMap, HttpSession httpSession, @RequestParam String tablestatusid) {

		Tablestatus tablestatus = tablestatusService.getInfoById(Integer.valueOf(tablestatusid.trim()));
		if (tablestatus == null) {
			modelMap.addAttribute("result", "Trạng thái bàn không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		tablestatus.setIsdelete(IS_DELETE);
		tablestatusService.editTablestatus(tablestatus);

		modelMap.addAttribute("result", "Xóa thành công!");
		return "/admin/public/Success";// đã tồn tại
	}

	@GetMapping(value = "/admin/table-status/edit")
	public String view(ModelMap modelMap, HttpSession httpSession, @RequestParam String tablestatusid) {

		Tablestatus tablestatus = tablestatusService.getInfoById(Integer.valueOf(tablestatusid.trim()));
		if (tablestatus == null) {
			modelMap.addAttribute("result", "Trạng thái bàn không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}
		
		tablestatus.setTablestatusdetails(null);

		modelMap.addAttribute("tablestatus", tablestatus);
		return "/admin/content/table-status/form";
	}

	@PostMapping(value = "/admin/table-status/edit")
	public String edit(ModelMap modelMap, HttpSession httpSession, @RequestParam String tablestatusid,
			@RequestParam String name) {

		Tablestatus tablestatus = tablestatusService.getInfoById(Integer.valueOf(tablestatusid.trim()));
		if (tablestatus == null) {
			modelMap.addAttribute("result", "Trạng thái bàn không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		tablestatus.setName(name);
		tablestatusService.editTablestatus(tablestatus);

		modelMap.addAttribute("result", "Cập nhật thành công!");
		return "/admin/public/Success";
	}
}
