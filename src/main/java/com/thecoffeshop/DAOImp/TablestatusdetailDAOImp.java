package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface TablestatusdetailDAOImp extends CommonDAOImp{

	public Boolean addTablestatusdetail(Tablestatusdetail tablestatusdetail);

	public List<Tablestatusdetail> findAll();

	public Tablestatusdetail getInfoById(TablestatusdetailId tablestatusdetailId);

	public Boolean deleteTablestatusdetail(TablestatusdetailId tablestatusdetailId);

	public Boolean editTablestatusdetail(Tablestatusdetail tablestatusdetail);
}
