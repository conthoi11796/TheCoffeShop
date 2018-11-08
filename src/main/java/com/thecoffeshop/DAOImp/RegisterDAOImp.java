package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface RegisterDAOImp extends CommonDAOImp {

	public Boolean addRegister(Register register);

    public Register getInfoById(RegisterId registerId);
    
    public List<Register> getListRegisterOnWeek(int moth);

	public Boolean deleteRegister(RegisterId registerId);

	public Boolean editRegister(Register register);
}
