package com.thecoffeshop.Controller;

import java.text.ParseException;
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
public class ScheduleController extends Common {

	@Autowired
	ScheduleService scheduleService;

	@GetMapping(value = "/admin/schedule")
	public String index(ModelMap modelMap, HttpSession httpSession) {

		return "/admin/schedule";
	}

	@GetMapping(value = "/admin/schedule/table")
	public String tbody(ModelMap modelMap, HttpSession httpSession) {

		List<Schedule> schedules = scheduleService.findAll();
		modelMap.addAttribute("schedules", schedules);

		return "/admin/content/schedule/tBody";
	}

	@PostMapping(value = "/admin/schedule/insert")
	public String insert(ModelMap modelMap, HttpSession httpSession, @RequestParam String scheduleid,
			@RequestParam String starttime, @RequestParam String endtime, @RequestParam String payrate)
			throws ParseException {

		if (scheduleService.getInfoById(scheduleid.trim()) != null) {

			modelMap.addAttribute("result", "Mã đã tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		Schedule schedule = new Schedule();
		schedule.setScheduleid(scheduleid.trim());
		schedule.setStarttime(super.sdfTimeField.parse(starttime.trim()));
		schedule.setEndtime(super.sdfTimeField.parse(endtime.trim()));
		schedule.setPayrate(Float.valueOf(payrate.trim()));
		schedule.setCreateat(new Date());
//		schedule.setCreateby(createby);
		schedule.setUpdateat(new Date());
		schedule.setIsdelete(super.IS_NOT_DELETE);
		scheduleService.addSchedule(schedule);

		List<Schedule> schedules = scheduleService.findAll();
		modelMap.addAttribute("schedules", schedules);

		modelMap.addAttribute("result", "Thêm thành công!");
		return "/admin/public/Success"; // thành công
	}

	@PostMapping(value = "/admin/schedule/remove")
	public String remove(ModelMap modelMap, HttpSession httpSession, @RequestParam String scheduleid) {

		Schedule schedule = scheduleService.getInfoById(scheduleid);
		if (schedule == null) {
			modelMap.addAttribute("result", "Ca làm không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}
		schedule.setIsdelete(this.IS_DELETE);
		scheduleService.editSchedule(schedule);

		modelMap.addAttribute("result", "Xóa thành công!");
		return "/admin/public/Success";// đã tồn tại
	}

	@GetMapping(value = "/admin/schedule/edit")
	public String view(ModelMap modelMap, HttpSession httpSession, @RequestParam String scheduleid) {

		Schedule schedule = scheduleService.getInfoById(scheduleid);
		if (schedule == null) {
			modelMap.addAttribute("result", "Ca làm không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		modelMap.addAttribute("schedule", schedule);
		return "/admin/content/schedule/form";
	}

	@PostMapping(value = "/admin/schedule/edit")
	public String edit(ModelMap modelMap, HttpSession httpSession, @RequestParam String scheduleid,
			@RequestParam String starttime, @RequestParam String endtime, @RequestParam String payrate)
			throws ParseException {

		Schedule schedule = scheduleService.getInfoById(scheduleid);
		if (schedule == null) {
			modelMap.addAttribute("result", "Ca làm không tồn tại!");
			return "/admin/public/Danger";// đã tồn tại
		}

		schedule.setStarttime(super.sdfTimeField.parse(starttime.trim()));
		schedule.setEndtime(super.sdfTimeField.parse(endtime.trim()));
		schedule.setPayrate(Float.valueOf(payrate.trim()));
//		schedule.setUpdateby(updateby);
		schedule.setUpdateat(new Date());
		scheduleService.editSchedule(schedule);

		modelMap.addAttribute("result", "Cập nhật thành công!");
		return "/admin/public/Success";
	}
}
