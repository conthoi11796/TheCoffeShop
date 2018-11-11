package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class AtpositionDAO implements AtpositionDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addAtposition(Atposition atposition) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(atposition);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Atposition getInfoById(AtpositionId atpositionId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			Atposition atposition = session
					.createQuery("FROM Atposition a WHERE a.AtpositionId = :atpositionId AND e.isdelete =: isdelete",
							Atposition.class)
					.setParameter("atpositionId", atpositionId).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return atposition;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteAtposition(AtpositionId atpositionId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Atposition atposition = this.getInfoById(atpositionId);
			session.remove(atposition);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editAtposition(Atposition atposition) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(atposition);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
