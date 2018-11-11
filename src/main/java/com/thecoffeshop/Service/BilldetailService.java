package com.thecoffeshop.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Service
@Transactional
public class BilldetailService implements BilldetailDAOImp {

	@Autowired
	BilldetailDAO billdetailDAO;

	@Override
	public Boolean addBilldetail(Billdetail billdetail) {

		billdetail.setCreateat(new Date());
		billdetail.setIsdelete(this.IS_NOT_DELETE);
		return billdetailDAO.addBilldetail(billdetail);
	}

	@Override
	public List<Billdetail> getInfoBilldetailByBillId(int billid) {
		// TODO Auto-generated method stub
		return billdetailDAO.getInfoBilldetailByBillId(billid);
	}

	@Override
	public Billdetail getInfoBilldetailByBilldetailId(BilldetailId billdetailId) {
		// TODO Auto-generated method stub
		return billdetailDAO.getInfoBilldetailByBilldetailId(billdetailId);
	}

	@Override
	public Boolean deleteBilldetail(BilldetailId billdetailId) {
		// TODO Auto-generated method stub
		return billdetailDAO.deleteBilldetail(billdetailId);
	}

	@Override
	public Boolean editBilldetail(Billdetail billdetail) {
		// TODO Auto-generated method stub
		return billdetailDAO.editBilldetail(billdetail);
	}


}