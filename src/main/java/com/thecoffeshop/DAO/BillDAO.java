package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Bill;
@Repository()
@Transactional(rollbackFor = Exception.class)
public class BillDAO implements BillDAOImp {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int addBill(Bill bill) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			int lastId = (Integer)session.save(bill);
			return lastId;
		} catch (Exception e) {
			return -1;
		}

	}

}
