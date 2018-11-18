package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface ScheduleDAOImp extends CommonDAOImp {

	public Boolean addSchedule(Schedule schedule);

	public List<Schedule> findAll();

	public List<Schedule> findLimit(int startPosition);

	public Schedule getInfoById(String scheduleid);

	public Boolean deleteSchedule(String scheduleid);

	public Boolean editSchedule(Schedule schedule);
}
