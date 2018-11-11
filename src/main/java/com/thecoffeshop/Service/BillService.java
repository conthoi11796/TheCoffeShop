package com.thecoffeshop.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Bill;

@Service
@Transactional
public class BillService implements BillDAOImp {

	@Autowired
	BillDAO billDAO;

	@Override
	public int addBill(Bill bill) {

		bill.setCreateat(new Date());
		bill.setIsdelete(this.IS_NOT_DELETE);
		return billDAO.addBill(bill);
	}

	@Override
	public List<Bill> findAll() {
		// TODO Auto-generated method stub
		return billDAO.findAll();
	}

	@Override
	public Bill getInfoById(int billid) {
		// TODO Auto-generated method stub
		return billDAO.getInfoById(billid);
	}

	@Override
	public Boolean deleteBill(int billid) {
		// TODO Auto-generated method stub
		return billDAO.deleteBill(billid);
	}

	@Override
	public Boolean editBill(Bill bill) {
		// TODO Auto-generated method stub
		return billDAO.editBill(bill);
	}

	@Override
	public Boolean checkExistBillStatus(String billstatusid) {
		// TODO Auto-generated method stub
		return billDAO.checkExistBillStatus(billstatusid);
	}

}
