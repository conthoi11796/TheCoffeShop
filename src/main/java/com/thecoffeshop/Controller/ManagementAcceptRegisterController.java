package com.thecoffeshop.Controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thecoffeshop.DTO.RegisterDTO;
import com.thecoffeshop.DTO.ScheduleDTO;
import com.thecoffeshop.Models.Employee;
import com.thecoffeshop.Models.Register;
import com.thecoffeshop.Models.Schedule;
import com.thecoffeshop.Service.RegisterService;
import com.thecoffeshop.Service.ScheduleService;

@Controller
public class ManagementAcceptRegisterController {

	@Autowired
	RegisterService registerService;
	@Autowired
	ScheduleService scheduleService;

	@GetMapping(value = "/admin/accept-register")
	public String index(ModelMap modelMap) {

		List<ScheduleDTO> scheduleDTOs = new ArrayList<ScheduleDTO>();
		List<Schedule> schedules = scheduleService.findAll();
		for (Schedule schedule : schedules) {
			ScheduleDTO dto = new ScheduleDTO();
			dto.setScheduleid(schedule.getScheduleid());
			scheduleDTOs.add(dto);
		}
		modelMap.addAttribute("scheduleDTOs", scheduleDTOs);

		Calendar c = Calendar.getInstance();
		int now = c.get(Calendar.DAY_OF_WEEK);
		c.roll(c.DAY_OF_MONTH, 8 - now);
		Date from = c.getTime();
		c.roll(c.DAY_OF_MONTH, 7);
		Date to = c.getTime();
		List<Register> registers = registerService.getListRegisterOnWeek(from, to);

		List<RegisterDTO> dtos = new ArrayList<RegisterDTO>();
		c.setTime(from);
		for (int i = 1; i <= 7; i++) {
			for (Schedule schedule : schedules) {
				String scheduleid = schedule.getScheduleid();
				RegisterDTO dto = new RegisterDTO();
				dto.setDay(i);
				dto.setScheduleid(scheduleid);

				List<Register> registers2 = registerService.listByDateScheduleid(c.getTime(), scheduleid);

				dto.setRegisters(registers2);

				dtos.add(dto);
			}
			c.roll(c.DAY_OF_MONTH, 1);
		}

		modelMap.addAttribute("dtos", dtos);

		return "/admin/management-employee/accept-register";
	}

	@PostMapping(value = "/admin/accept-register")
	public @ResponseBody String accept(@RequestParam String listRegisterid) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode jsonObject = objectMapper.readTree(listRegisterid);
			JsonNode jsonArray = jsonObject.get("listRegisterid");
			for (JsonNode registerid : jsonArray) {
				int id = registerid.get("registerid").asInt();
				int result = registerid.get("result").asInt();

				Register register = registerService.getInfoById(id);
				register.setResult(result);
				register.setUpdateat(new Date());
				registerService.editRegister(register);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Duyệt thành công!";
	}

}
