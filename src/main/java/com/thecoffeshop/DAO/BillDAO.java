package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	@Override
	public List<Bill> findAllBill() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Bill> bills = session
					.createQuery("FROM Bill b WHERE b.isdelete =: isdelete",
					Bill.class).setParameter("isdelete", this.IS_NOT_DELETE)
					.getResultList();
			return bills;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Bill getInfoById(int billid) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Bill bill = session
					.createQuery("FROM Bill b WHERE p.billid = :billid AND p.isdelete =: isdelete",
					Bill.class).setParameter("billid", billid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return bill;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteBill(int billid) {
				
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Bill bill = this.findInfoById(billid);

			if(bill!=null){
				if(session.remove(bill)){
					return true;
				}
				return false;
			}
			return false;	
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editBill(Bill bill) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			if(session.save(bill)){
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

}
