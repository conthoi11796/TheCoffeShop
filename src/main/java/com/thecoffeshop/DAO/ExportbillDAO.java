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
public class ExportbillDAO implements ExportbillDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addExportbill(Exportbill exportbill) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			int lastID = (Integer)session.save(exportbill);
			return lastID;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public List<Exportbill> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			List<Exportbill> exportbills = session
					.createQuery("FROM Exportbill e WHERE e.isdelete =: isdelete", Exportbill.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return exportbills;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Exportbill getInfoById(int exportbillid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			Exportbill exportbill = session
					.createQuery("FROM Exportbill e WHERE e.exportbillid =: exportbillid AND e.isdelete =: isdelete",
							Exportbill.class)
					.setParameter("exportbillid", exportbillid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return exportbill;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteExportbill(int exportbillid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Exportbill exportbill = this.getInfoById(exportbillid);
			session.remove(exportbill);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editExportbill(Exportbill exportbill) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(exportbill);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int totalQuantityProduct(String productid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			int total = 0;
			List<Exportbill> exportbills = session.createQuery(
					"FROM Exportbill e WHERE e.product.productid =: productid AND e.quantity > 0 AND e.isdelete =: isdelete",
					Exportbill.class).setParameter("productid", productid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getResultList();
			for (Exportbill exportbill : exportbills) {
				total += exportbill.getQuantityInventory();
			}
			return total;
		} catch (Exception e) {

			return 0;
		}
	}

	@Override
	public List<Exportbill> getListExportBillbyProduct(String productid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Exportbill> exportbills = session.createQuery(
					"FROM Exportbill e WHERE e.product.productid =: productid AND e.quantityInventory > 0 AND e.isdelete =: isdelete ORDER BY updateat ASC",
					Exportbill.class).setParameter("productid", productid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getResultList();

			return exportbills;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Exportbill> findLimit(int startPosition) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			List<Exportbill> exportbills = session
					.createQuery("FROM Exportbill e WHERE e.isdelete =: isdelete", Exportbill.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).setFirstResult(startPosition*MAX_RESULTS).setMaxResults(MAX_RESULTS).getResultList();
			return exportbills;
		} catch (Exception e) {

			return null;
		}
	}

}