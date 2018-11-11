package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface BillDAOImp extends CommonDAOImp{

	public int addBill(Bill bill);

	public List<Bill> findAll();

	public Bill getInfoById(int billid);

	public Boolean deleteBill(int billid);

	public Boolean editBill(Bill bill);
	
	public Boolean checkExistBillStatus(String billstatusid);
}
