package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Bill;
import com.thecoffeshop.Models.Billstatus;
import com.thecoffeshop.Models.Dinnertable;
import com.thecoffeshop.Models.Voucher;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class BillDAO implements BillDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addBill(Bill bill) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			int lastId = (Integer) session.save(bill);
			return lastId;
		} catch (Exception e) {
			return -1;
		}

	}

	@Override
	public List<Bill> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Bill> bills = session.createQuery("FROM Bill b WHERE b.isdelete =: isdelete", Bill.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
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
					.createQuery("FROM Bill b WHERE b.billid = :billid AND b.isdelete =: isdelete", Bill.class)
					.setParameter("billid", billid).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return bill;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteBill(int billid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Bill bill = this.getInfoById(billid);
			session.remove(bill);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editBill(Bill bill) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(bill);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean checkExistBillStatus(String billstatusid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Bill> bills = session
					.createQuery("FROM Bill b WHERE b.billstatus = :billstatus AND b.isdelete =: isdelete", Bill.class)
					.setParameter("billstatus", new Billstatus(billstatusid))
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

			if (bills.size() > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public Boolean checkExistVoucher(int voucherid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Bill> bills = session
					.createQuery("FROM Bill b WHERE b.voucher = :voucher AND b.isdelete =: isdelete", Bill.class)
					.setParameter("voucher", new Voucher(voucherid)).setParameter("isdelete", this.IS_NOT_DELETE)
					.getResultList();

			if (bills.size() > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public Boolean checkExistDinnerTable(int dinnertableid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Bill> bills = session
					.createQuery("FROM Bill b WHERE b.dinnertable = :dinnertable AND b.isdelete =: isdelete",
							Bill.class)
					.setParameter("dinnertable", new Dinnertable(dinnertableid))
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

			if (bills.size() > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public List<Bill> findLimit(int startPosition) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Bill> bills = session.createQuery("FROM Bill b WHERE b.isdelete =: isdelete", Bill.class)
					.setFirstResult(startPosition * MAX_RESULTS).setMaxResults(MAX_RESULTS)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return bills;
		} catch (Exception e) {

			return null;
		}
	}
}
