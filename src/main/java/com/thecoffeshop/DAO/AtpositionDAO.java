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

	@Override
	public Boolean checkExistPosition(String positionid) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {

			List<Atposition> atpositions = session
					.createQuery("FROM Atposition a WHERE a.id = :id AND e.isdelete =: isdelete",
							Atposition.class)
					.setParameter("id", new AtpositionId("1")).setParameter("isdelete", this.IS_NOT_DELETE)
					.getResultList();
			if(atpositions.size()>0) {
				return true;
			}
			return false;
		} catch (Exception e) {

			return false;
		}
	}

//	@Override
//	public Atposition getInfoByEmployeeId(String employeeid) {
//
//		Session session = this.sessionFactory.getCurrentSession();
//		try {
//
//			Atposition atposition = session.createQuery(
//					"FROM Atposition a WHERE p.startdate > date() AND a.AtpositionId = :atpositionId AND a.isdelete =: isdelete ORDER BY a.startdate DESC",
//					Atposition.class).setParameter("atpositionId", new AtpositionId(employeeid, null))
//					.setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
//			return atposition;
//		} catch (Exception e) {
//
//			return null;
//		}
//	}

}
