package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Bill;
import com.thecoffeshop.Models.Dinnertable;
import com.thecoffeshop.Models.Position;
import com.thecoffeshop.Models.Tablestatus;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class TablestatusDAO implements TablestatusDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addTablestatus(Tablestatus tablestatus) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(tablestatus);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Tablestatus> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Tablestatus> tablestatus = session
					.createQuery("FROM Tablestatus tb WHERE tb.isdelete =: isdelete", Tablestatus.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return tablestatus;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Tablestatus getInfoById(int tablestatusid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Tablestatus tablestatus = session
					.createQuery(
							"FROM Tablestatus tb WHERE tb.tablestatusid =: tablestatusid AND tb.isdelete =: isdelete",
							Tablestatus.class)
					.setParameter("tablestatusid", tablestatusid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return tablestatus;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteTablestatus(int tablestatusid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Tablestatus tablestatus = this.getInfoById(tablestatusid);
			session.remove(tablestatus);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editTablestatus(Tablestatus tablestatus) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(tablestatus);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean checkExist(String name) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Tablestatus tablestatus = session
					.createQuery("FROM Tablestatus tb WHERE tb.name =: name AND tb.isdelete =: isdelete",
							Tablestatus.class)
					.setParameter("name", name).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public List<Tablestatus> findLimit(int startPosition) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Tablestatus> tablestatus = session
					.createQuery("FROM Tablestatus tb WHERE tb.isdelete =: isdelete", Tablestatus.class)
					.setFirstResult(startPosition*MAX_RESULTS).setMaxResults(MAX_RESULTS).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return tablestatus;
		} catch (Exception e) {

			return null;
		}
	}

}