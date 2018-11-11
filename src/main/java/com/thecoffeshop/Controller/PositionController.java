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
public class PositionController extends Common {

	@Autowired
	PositionService positionService;

	@GetMapping(value = "/admin/position")
	public String index(ModelMap modelMap, HttpSession httpSession) {

		return "/admin/position";
	}

	@GetMapping(value = "/admin/position/table")
	public String tbody(ModelMap modelMap, HttpSession httpSession) {

		List<Position> positions = positionService.findAll();
		modelMap.addAttribute("positions", positions);

		return "/admin/content/position/tBody";
	}

	@PostMapping(value = "/admin/position/insert")
	public String insert(ModelMap modelMap, HttpSession httpSession, @RequestParam String positionid,
			@RequestParam String name) {

		if (positionService.getInfoById(positionid.trim()) != null) {

			modelMap.addAttribute("result", "Mã đã tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}
		if (positionService.getInfoByName(name.trim()) != null) {

			modelMap.addAttribute("result", "Lỗi trùng tên!");
			return "/admin/public/Danger";// đã tồn tại
		}
		
		Position position = new Position();
		position.setPositionid(positionid.trim());
		position.setName(name.trim());
//		position.setCreateby(createby);
		position.setCreateat(new Date());
		position.setUpdateat(new Date());
		position.setIsdelete(super.IS_NOT_DELETE);
		positionService.addPosition(position);

		List<Position> positions = positionService.findAll();
		modelMap.addAttribute("positions", positions);

		modelMap.addAttribute("result", "Thêm thành công!");
		return "/admin/public/Success"; // thành công
	}

	@PostMapping(value = "/admin/position/remove")
	public String remove(ModelMap modelMap, HttpSession httpSession, @RequestParam String positionid) {

		Position position = positionService.getInfoById(positionid);
		if (position == null) {
			modelMap.addAttribute("result", "Chức vụ không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}
		position.setIsdelete(super.IS_DELETE);
//		position.setUpdateby(updateby);
		position.setUpdateat(new Date());
		positionService.editPosition(position);

		modelMap.addAttribute("result", "Xóa thành công!");
		return "/admin/public/Success";// đã tồn tại
	}

	@GetMapping(value = "/admin/position/edit")
	public String view(ModelMap modelMap, HttpSession httpSession, @RequestParam String positionid) {

		Position position = positionService.getInfoById(positionid);
		if (position == null) {
			modelMap.addAttribute("result", "Chức vụ không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		modelMap.addAttribute("position", position);
		return "/admin/content/position/form";
	}

	@PostMapping(value = "/admin/position/edit")
	public String edit(ModelMap modelMap, HttpSession httpSession, @RequestParam String positionid,
			@RequestParam String name) {

		Position position = positionService.getInfoById(positionid);
		if (position == null) {
			modelMap.addAttribute("result", "Chức vụ không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}
		if (positionService.getInfoByName(name.trim()) != null) {

			modelMap.addAttribute("result", "Lỗi trùng tên!");
			return "/admin/public/Danger";// đã tồn tại
		}

		position.setName(name.trim());
//		position.setUpdateby(updateby);
		position.setUpdateat(new Date());
		positionService.editPosition(position);

		modelMap.addAttribute("result", "Cập nhật thành công!");
		return "/admin/public/Success";
	}
}
