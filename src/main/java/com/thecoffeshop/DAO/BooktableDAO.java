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
import com.thecoffeshop.Models.Booktable;
import com.thecoffeshop.Models.BooktableId;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class BooktableDAO implements BooktableDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addBooktable(Booktable booktable) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(booktable);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Booktable> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Booktable> booktables = session
					.createQuery("FROM Booktable b WHERE b.isdelete =: isdelete", Booktable.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return booktables;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Booktable getInfoByBooktableId(BooktableId booktableId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Booktable booktable = session
					.createQuery("FROM Booktable b WHERE BooktableId =:booktableId AND b.isdelete =: isdelete",
							Booktable.class)
					.setParameter("booktableId", booktableId).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return booktable;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean deleteBooktable(BooktableId booktableId) {

		Session session = this.sessionFactory.getCurrentSession();

		try {
			Booktable booktable = this.getInfoByBooktableId(booktableId);
			session.remove(booktable);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editBooktable(Booktable booktable) {
		return null;
	}

}