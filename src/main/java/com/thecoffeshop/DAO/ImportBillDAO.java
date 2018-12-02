package com.thecoffeshop.DAO;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.ImportBillDAOImp;
import com.thecoffeshop.Models.Importbill;
import com.thecoffeshop.Models.Importbilldetail;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class ImportBillDAO implements ImportBillDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addImportBill(Importbill importbill) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			int lastId = (Integer) session.save(importbill);
			return lastId;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public List<Importbill> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Importbill> importbills = session
					.createQuery("FROM Importbill i WHERE i.isdelete =: isdelete", Importbill.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return importbills;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Importbill> findLimit(int startPosition) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Importbill> importbills = session
					.createQuery("FROM Importbill i WHERE i.isdelete =: isdelete", Importbill.class)
					.setFirstResult(startPosition * MAX_RESULTS).setMaxResults(MAX_RESULTS)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return importbills;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Importbill getInfoById(int importbillid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Importbill importbill = session
					.createQuery("FROM Importbill i WHERE i.importbillid =: importbillid AND i.isdelete =: isdelete",
							Importbill.class)
					.setParameter("importbillid", importbillid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return importbill;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteImportBill(int importbillid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Importbill importbill = this.getInfoById(importbillid);
			session.remove(importbill);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editImportBill(Importbill importbill) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(importbill);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int tongtienImportBill(Date date) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Importbill> importbills = session
					.createQuery("FROM Importbill i WHERE  DATE(i.updateat) = DATE(:date) AND i.isdelete =: isdelete",
							Importbill.class)
					.setParameter("date", date).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			int total = 0;
			for (Importbill importbill : importbills) {
				Set<Importbilldetail> importbilldetails = importbill.getImportbilldetails();
				for (Importbilldetail importbilldetail : importbilldetails) {
					total += importbilldetail.getMaterialdetail().getQuantity()
							* importbilldetail.getMaterialdetail().getPrice();
				}
			}
			return total;
		} catch (Exception e) {

			return 0;
		}
	}

	@Override
	public int soluongImportBill(Date date) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Importbill> importbills = session
					.createQuery("FROM Importbill i WHERE  DATE(i.updateat) = DATE(:date) AND i.isdelete =: isdelete",
							Importbill.class)
					.setParameter("date", date).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

			return importbills.size();
		} catch (Exception e) {

			return 0;
		}
	}

	@Override
	public int tongtienImportBillTrongTuan(int tuan) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Importbill> importbills = session
					.createQuery("FROM Importbill i WHERE WEEK(i.updateat) =: tuan AND i.isdelete =: isdelete",
							Importbill.class)
					.setParameter("tuan", tuan).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			int total = 0;
			for (Importbill importbill : importbills) {
				Set<Importbilldetail> importbilldetails = importbill.getImportbilldetails();
				for (Importbilldetail importbilldetail : importbilldetails) {
					total += importbilldetail.getMaterialdetail().getQuantity()
							* importbilldetail.getMaterialdetail().getPrice();
				}
			}
			return total;
		} catch (Exception e) {

			return 0;
		}
	}

	@Override
	public int soluongImportBillTrongTuan(int tuan) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Importbill> importbills = session
					.createQuery("FROM Importbill i WHERE WEEK(i.updateat) =: tuan AND i.isdelete =: isdelete",
							Importbill.class)
					.setParameter("tuan", tuan).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

			return importbills.size();
		} catch (Exception e) {

			return 0;
		}
	}

	@Override
	public int tongtienImportBillTrongThang(int thang) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Importbill> importbills = session
					.createQuery("FROM Importbill i WHERE MONTH(i.updateat) =: thang AND i.isdelete =: isdelete",
							Importbill.class)
					.setParameter("thang", thang).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			int total = 0;
			for (Importbill importbill : importbills) {
				Set<Importbilldetail> importbilldetails = importbill.getImportbilldetails();
				for (Importbilldetail importbilldetail : importbilldetails) {
					total += importbilldetail.getMaterialdetail().getQuantity()
							* importbilldetail.getMaterialdetail().getPrice();
				}
			}
			return total; 
		} catch (Exception e) {

			return 0;
		}
	}

	@Override
	public int soluongImportBillTrongThang(int thang) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Importbill> importbills = session
					.createQuery("FROM Importbill i WHERE MONTH(i.updateat) =: thang AND i.isdelete =: isdelete",
							Importbill.class)
					.setParameter("thang", thang).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

			return importbills.size();
		} catch (Exception e) {

			return 0;
		}
	}

}
