package com.thecoffeshop.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.ImportBillDAOImp;
import com.thecoffeshop.DAOImp.ImportbilldetailDAOImp;
import com.thecoffeshop.Models.Billdetail;
import com.thecoffeshop.Models.Importbill;
import com.thecoffeshop.Models.Importbilldetail;
import com.thecoffeshop.Models.ImportbilldetailId;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class ImportbilldetailDAO implements ImportbilldetailDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addImportbilldetail(Importbilldetail importbilldetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(importbilldetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Importbilldetail> getInfoByImportbillid(int importbillid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Importbilldetail> importbilldetails = session
					.createQuery(
							"FROM Importbilldetail i WHERE i.id.importbillid =:importbillid AND i.isdelete =: isdelete",
							Importbilldetail.class)
					.setParameter("importbillid", importbillid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getResultList();
			return importbilldetails;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Importbilldetail getInfoByImportbilldetailId(ImportbilldetailId id) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Importbilldetail importbilldetail = session
					.createQuery("FROM Importbilldetail i WHERE i.id =:id AND i.isdelete =: isdelete",
							Importbilldetail.class)
					.setParameter("id", id).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return importbilldetail;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteImportbilldetail(Importbilldetail importbilldetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(importbilldetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editImportbilldetail(Importbilldetail importbilldetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(importbilldetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int getNumberImportbilldetail(int importbillid) {

		List<Importbilldetail> importbilldetails = getInfoByImportbillid(importbillid);
		if (importbilldetails == null) {
			return 0;
		} else {
			return importbilldetails.size();
		}
	}

	@Override
	public Boolean checkExistMaterialDetail(int materialdetailid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Importbilldetail importbilldetail = session.createQuery(
					"FROM Importbilldetail i WHERE i.id.materialdetailid =:materialdetailid AND i.isdelete =: isdelete",
					Importbilldetail.class).setParameter("materialdetailid", materialdetailid)
					.setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return true;
		} catch (Exception e) {

			return false;
		}
	}

}
