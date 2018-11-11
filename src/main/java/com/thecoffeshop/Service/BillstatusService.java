package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Service
@Transactional
public class BillstatusService implements BillstatusDAOImp {

	@Autowired
	BillstatusDAO billstatusDAO;

	@Override
	public Boolean addBillstatus(Billstatus billstatus) {
		// TODO Auto-generated method stub
		return billstatusDAO.addBillstatus(billstatus);
	}

	@Override
	public List<Billstatus> findAll() {
		// TODO Auto-generated method stub
		return billstatusDAO.findAll();
	}

	@Override
	public Billstatus getInfoById(String billstatusid) {
		// TODO Auto-generated method stub
		return billstatusDAO.getInfoById(billstatusid);
	}

	@Override
	public Boolean deleteBillstatus(String billstatusid) {
		// TODO Auto-generated method stub
		return billstatusDAO.deleteBillstatus(billstatusid);
	}

	@Override
	public Boolean editBilldetail(Billstatus billstatus) {
		// TODO Auto-generated method stub
		return billstatusDAO.editBilldetail(billstatus);
	}

	@Override
	public List<Billstatus> findLimit(int startPosition) {
		// TODO Auto-generated method stub
		return billstatusDAO.findLimit(startPosition);
	}
}