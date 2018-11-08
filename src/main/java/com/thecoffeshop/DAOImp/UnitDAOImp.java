package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface UnitDAOImp extends CommonDAOImp{

	public Boolean addUnit(Unit unit);

    public List<Unit> findAll();

	public Unit getInfoById(String unitid);

	public Boolean deleteUnit(String unitid);

	public Boolean editUnit(Unit unit);
}
