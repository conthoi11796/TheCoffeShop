package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class BillstatusDAO implements BillstatusDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addBillstatus(Billstatus billstatus) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(billstatus);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Billstatus> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Billstatus> billstatus = session
					.createQuery("FROM Billstatus b WHERE b.isdelete =: isdelete", Billstatus.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return billstatus;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Billstatus getInfoById(String billstatusid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Billstatus billstatus = session
					.createQuery("FROM Billstatus b WHERE b.billstatusid = :billstatusid AND b.isdelete =: isdelete",
							Billstatus.class)
					.setParameter("billstatusid", billstatusid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return billstatus;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean deleteBillstatus(String billstatusid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Billstatus billstatus = this.getInfoById(billstatusid);
			session.remove(billstatus);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editBilldetail(Billstatus billstatus) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(billstatus);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Billstatus> findLimit(int startPosition) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Billstatus> billstatus = session
					.createQuery("FROM Billstatus b WHERE b.isdelete =: isdelete", Billstatus.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).setFirstResult(startPosition*this.MAX_RESULTS).setMaxResults(this.MAX_RESULTS).getResultList();
			return billstatus;
		} catch (Exception e) {
			return null;
		}
	}
}