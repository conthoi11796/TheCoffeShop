package com.thecoffeshop.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class TablestatusdetailDAO implements TablestatusdetailDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addTablestatusdetail(Tablestatusdetail tablestatusdetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(tablestatusdetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Tablestatusdetail> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Tablestatusdetail> tablestatusdetails = session
					.createQuery("FROM Tablestatusdetail tsd WHERE tsd.isdelete =: isdelete", Tablestatusdetail.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return tablestatusdetails;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Tablestatusdetail getInfoById(int dinnertableidId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Tablestatusdetail> tablestatusdetails = session.createQuery(
					"FROM Tablestatusdetail tsd WHERE tsd.TablestatusdetailId =: id AND tsd.isdelete =: isdelete",
					Tablestatusdetail.class).setParameter("id", new TablestatusdetailId(dinnertableidId, 1))
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			System.out.println(tablestatusdetails.size());

			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean deleteTablestatusdetail(TablestatusdetailId tablestatusdetailId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.remove(tablestatusdetailId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editTablestatusdetail(Tablestatusdetail tablestatusdetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(tablestatusdetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean checkExitsDinnerTable(int dinnertableid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Tablestatusdetail> tablestatusdetails = session.createQuery(
					"FROM Tablestatusdetail tsd WHERE tsd.id.dinnertableid = :dinnertableid AND tsd.isdelete =: isdelete",
					Tablestatusdetail.class).setParameter("dinnertableid", dinnertableid)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			if (tablestatusdetails.size() > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}