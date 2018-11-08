package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface DinnertableDAOImp extends CommonDAOImp{

	public Boolean addDinnertable(Dinnertable dinnertable);

	public List<Dinnertable> findAll();

	public Dinnertable getInfoById(int dinnertableid);

	public Boolean deleteDinnertable(int dinnertableid);

	public Boolean editDinnertable(Dinnertable dinnertable);
}
