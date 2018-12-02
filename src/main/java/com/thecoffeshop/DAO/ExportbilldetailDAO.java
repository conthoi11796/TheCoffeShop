package com.thecoffeshop.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.ExportbilldetailDAOImp;
import com.thecoffeshop.Models.Exportbilldetail;
import com.thecoffeshop.Models.ExportbilldetailId;
import com.thecoffeshop.Models.Importbilldetail;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class ExportbilldetailDAO implements ExportbilldetailDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addExportbilldetail(Exportbilldetail exportbilldetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(exportbilldetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Exportbilldetail> getInfoByExportbillId(int exportbillid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Exportbilldetail> exportbilldetails = session
					.createQuery(
							"FROM Exportbilldetail e WHERE e.id.exportbillid =:exportbillid AND e.isdelete =: isdelete",
							Exportbilldetail.class)
					.setParameter("exportbillid", exportbillid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getResultList();
			return exportbilldetails;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Exportbilldetail getInfoByExportbilldetail(ExportbilldetailId id) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Exportbilldetail exportbilldetail = session
					.createQuery("FROM Exportbilldetail e WHERE e.id =:id AND e.isdelete =: isdelete",
							Exportbilldetail.class)
					.setParameter("id", id).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return exportbilldetail;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteExportbilldetail(Exportbilldetail exportbilldetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.remove(exportbilldetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editExportbilldetail(Exportbilldetail exportbilldetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(exportbilldetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int getNumberExportbilldetail(int exportbillid) {

		List<Exportbilldetail> exportbilldetails = getInfoByExportbillId(exportbillid);
		if (exportbilldetails == null) {
			return 0;
		} else {
			return exportbilldetails.size();
		}
	}

	@Override
	public Boolean checkExistMaterialDetail(int materialdetailid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Exportbilldetail exportbilldetail = session.createQuery(
					"FROM Exportbilldetail e WHERE e.id.materialdetailid =:materialdetailid AND e.isdelete =: isdelete",
					Exportbilldetail.class).setParameter("materialdetailid", materialdetailid)
					.setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return true;
		} catch (Exception e) {

			return false;
		}
	}

}
