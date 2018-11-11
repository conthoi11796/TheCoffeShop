package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface BillstatusDAOImp extends CommonDAOImp{ 

	public Boolean addBillstatus(Billstatus billstatus);

	public List<Billstatus> findAll();

	public Billstatus getInfoById(String billstatusid);

	public Boolean deleteBillstatus(String billstatusid);

	public Boolean editBilldetail(Billstatus billstatus);
}
