package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface BilldetailDAOImp extends CommonDAOImp{

	public int addBilldetail(Billdetail billdetail);

	public List<Billdetail> getInfoBilldetailByBillId(int billid);

	public Billdetail getInfoBilldetailByBilldetailId(BilldetailId billdetailId);

	public Boolean deleteBilldetail(BilldetailId billdetailId);

	public Boolean editBilldetail(Billdetail billdetail);
}
