package com.thecoffeshop.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.Models.*;
import com.thecoffeshop.DAOImp.*;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class MaterialdetailDAO implements MaterialdetailDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addMaterialdetail(Materialdetail materialdetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(materialdetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Materialdetail> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			List<Materialdetail> materialdetails = session
					.createQuery("FROM Materialdetail m WHERE m.isdelete =: isdelete", Materialdetail.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return materialdetails;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Materialdetail getInfoById(int materialdetailid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			Materialdetail materialdetail = session.createQuery(
					"FROM Materialdetail m WHERE m.materialdetailid =: materialdetailid AND m.isdelete =: isdelete",
					Materialdetail.class).setParameter("materialdetailid", materialdetailid)
					.setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return materialdetail;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteMaterialdetail(int materialdetailid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Materialdetail materialdetail = this.getInfoById(materialdetailid);
			session.remove(materialdetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editMaterialdetail(Materialdetail materialdetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(materialdetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}