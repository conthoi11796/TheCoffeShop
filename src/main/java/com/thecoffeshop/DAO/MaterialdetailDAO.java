package com.thecoffeshop.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.MaterialdetailDAOImp;
import com.thecoffeshop.Models.Materialdetail;
import com.thecoffeshop.Models.Product;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class MaterialdetailDAO implements MaterialdetailDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addMaterialdetail(Materialdetail materialdetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			int lastId = (Integer) session.save(materialdetail);
			return lastId;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public List<Materialdetail> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			List<Materialdetail> materialdetails = session
					.createQuery("FROM Materialdetail m WHERE m.quantity > 0 AND m.isdelete =: isdelete",
							Materialdetail.class)
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

	@Override
	public Boolean checkExistMaterial(int materialid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			List<Materialdetail> materialdetails = session.createQuery(
					"FROM Materialdetail m WHERE m.material.materialid =: materialid AND m.isdelete =: isdelete",
					Materialdetail.class).setParameter("materialid", materialid)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			if (materialdetails.size() > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public List<Materialdetail> layNguyenLieuTonKho(int materialid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			List<Materialdetail> materialdetails = session.createQuery(
					"FROM Materialdetail m WHERE m.quantity > 0 AND m.material.materialid =: materialid AND m.isdelete =: isdelete ORDER BY m.materialdetailid ASC",
					Materialdetail.class).setParameter("materialid", materialid)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return materialdetails;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public int laySoNguyenLieuTonKho(int materialid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			List<Materialdetail> materialdetails = session.createQuery(
					"FROM Materialdetail m WHERE m.quantity > 0 AND m.material.materialid =: materialid AND m.isdelete =: isdelete ORDER BY m.materialdetailid ASC",
					Materialdetail.class).setParameter("materialid", materialid)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			if (materialdetails.size() <= 0) {
				return 0;
			}
			int total = 0;
			for (Materialdetail materialdetail : materialdetails) {
				total += materialdetail.getQuantity();
			}
			return total;
		} catch (Exception e) {

			return 0;
		}
	}

	@Override
	public List<Materialdetail> search(String materialdetailid, String name) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			String hql = "FROM Materialdetail m WHERE m.quantity > 0 AND m.isdelete =: isdelete";
			if (materialdetailid != "") {
				hql = hql + " AND m.materialdetailid =: materialdetailid ";
			}
			if (name != "") {
				hql = hql + " AND m.material.name =: name ";
			}
			Query query = session.createQuery(hql, Materialdetail.class);
			query.setParameter("isdelete", this.IS_NOT_DELETE);
			if (materialdetailid != "") {
				query.setParameter("materialdetailid", Integer.valueOf(materialdetailid));
			}
			if (name != "") {
				query.setParameter("name", name);
			}
			List<Materialdetail> materialdetails = query.getResultList();
			return materialdetails;
			
		} catch (Exception e) {

			return null;
		}

	}

}