package com.thecoffeshop.DTO;

import com.thecoffeshop.Models.*;

public class ScheduleDTO {

	private Schedule schedule;

	private Boolean canDelete;

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Boolean getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}

}
