package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Service
@Transactional
public class ScheduleService implements ScheduleDAOImp {

	@Autowired
	ScheduleDAO scheduleDAO;

	@Override
	public Boolean addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleDAO.addSchedule(schedule);
	}

	@Override
	public List<Schedule> findAll() {
		// TODO Auto-generated method stub
		return scheduleDAO.findAll();
	}

	@Override
	public Schedule getInfoById(String scheduleid) {
		// TODO Auto-generated method stub
		return scheduleDAO.getInfoById(scheduleid);
	}

	@Override
	public Boolean deleteSchedule(String scheduleid) {
		// TODO Auto-generated method stub
		return scheduleDAO.deleteSchedule(scheduleid);
	}

	@Override
	public Boolean editSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleDAO.editSchedule(schedule);
	}
}