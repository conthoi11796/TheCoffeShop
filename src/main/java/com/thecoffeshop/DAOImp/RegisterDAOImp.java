package com.thecoffeshop.DAOImp;

import java.util.Date;
import java.util.List;

import com.thecoffeshop.Models.*;

public interface RegisterDAOImp extends CommonDAOImp {

	public Boolean addRegister(Register register);

	public Register getInfoById(int registerid);

	public List<Register> getListRegisterOnWeek(Date from, Date to);

	public Boolean checkExistSchedule(String scheduleid);

	public Boolean deleteRegister(Register register);

	public Boolean editRegister(Register register);

	// lấy list nhân viên đăng ký ca vào ngày nào, ca nào
	public List<Register> listByDateScheduleid(Date date, String scheduleid);
}
