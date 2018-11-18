package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Bill;
import com.thecoffeshop.Models.Dinnertable;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class DinnertableDAO implements DinnertableDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addDinnertable(Dinnertable dinnertable) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(dinnertable);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Dinnertable> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Dinnertable> dinnertables = session
					.createQuery("FROM Dinnertable d WHERE d.isdelete =: isdelete", Dinnertable.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return dinnertables;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Dinnertable getInfoById(int dinnertableid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Dinnertable dinnertable = session
					.createQuery("FROM Dinnertable d WHERE d.dinnertableid =: dinnertableid AND d.isdelete =: isdelete",
							Dinnertable.class)
					.setParameter("dinnertableid", dinnertableid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return dinnertable;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteDinnertable(int dinnertableid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Dinnertable dinnertable = this.getInfoById(dinnertableid);
			session.remove(dinnertable);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editDinnertable(Dinnertable dinnertable) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(dinnertable);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Dinnertable> findLimit(int startPosition) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Dinnertable> dinnertables = session
					.createQuery("FROM Dinnertable d WHERE d.isdelete =: isdelete", Dinnertable.class)
					.setFirstResult(startPosition * MAX_RESULTS).setMaxResults(MAX_RESULTS)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return dinnertables;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean checkExistDinnerTable(String name) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Dinnertable dinnertable = session
					.createQuery("FROM Dinnertable d WHERE d.name LIKE: name AND d.isdelete =: isdelete",
							Dinnertable.class)
					.setParameter("name", name).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public List<Integer> getListCountChair() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Dinnertable> dinnertables = session
					.createQuery("FROM Dinnertable d WHERE d.isdelete =: isdelete GROUP BY d.countchair", Dinnertable.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			
			List<Integer> integers = new ArrayList<Integer>();
			for (Dinnertable dinnertable : dinnertables) {
				integers.add(dinnertable.getCountchair());
			}
			
			return integers;
		} catch (Exception e) {

			return null;
		}
	}
}