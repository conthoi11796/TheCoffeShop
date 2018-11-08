package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface MaterialdetailDAOImp extends CommonDAOImp{
	
	public int addMaterialdetail(Materialdetail materialdetail);

	public List<Materialdetail> findAll();

	public Materialdetail getInfoById(int materialdetailid);

	public Boolean deleteMaterialdetail(int materialdetailid);

	public Boolean editMaterialdetail(Materialdetail materialdetail);
}
