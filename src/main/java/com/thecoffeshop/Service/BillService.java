package com.thecoffeshop.Service;

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

		return billDAO.addBill(bill);
	}

}
