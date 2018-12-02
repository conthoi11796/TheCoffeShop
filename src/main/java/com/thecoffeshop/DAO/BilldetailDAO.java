package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;
import com.thecoffeshop.Service.BillService;
import com.thecoffeshop.Service.PriceService;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class BilldetailDAO implements BilldetailDAOImp {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PriceService priceService;
	@Autowired
	private BillService billService;
	@Autowired
	private VoucherDAO voucherDAO;

	@Override
	public Boolean addBilldetail(Billdetail billdetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(billdetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Billdetail> getInfoBilldetailByBillId(int billid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Billdetail> billdetails = session
					.createQuery("FROM Billdetail b WHERE b.id.billid =:billid AND b.isdelete =: isdelete",
							Billdetail.class)
					.setParameter("billid", billid).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return billdetails;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Billdetail getInfoBilldetailByBilldetailId(BilldetailId billdetailId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Billdetail billdetail = session
					.createQuery("FROM Billdetail b WHERE b.id =:id AND b.isdelete =: isdelete", Billdetail.class)
					.setParameter("id", billdetailId).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return billdetail;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean deleteBilldetail(BilldetailId billdetailId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Billdetail billdetail = this.getInfoBilldetailByBilldetailId(billdetailId);
			session.delete(billdetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editBilldetail(Billdetail billdetail) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(billdetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int getPriceOfBillDetail(BilldetailId billdetailId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			int billId = billdetailId.getBillid();
			Date startdatetime = billService.getInfoById(billId).getStartdatetime();

			// lấy số lượng của sản phẩm
			Billdetail billdetail = session
					.createQuery("FROM Billdetail b WHERE b.id =: id AND  b.isdelete =: isdelete", Billdetail.class)
					.setParameter("id", billdetailId).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();

			// giá = số lượng * giá của sản phẩm
			int price = billdetail.getQuantity()
					* getSinglePriceOfBillDetail(billdetailId.getProductid(), startdatetime);

			return price;

		} catch (Exception e) {

			return 0;
		}
	}

	@Override
	public int getSinglePriceOfBillDetail(String productid, Date startdatetime) {

		// lấy giá có ngày áp dụng <= startdatetime, sắp xếp giảm theo ngày và lấy dòng
		// đầu trong table
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Price price = session.createQuery(
					"FROM Price p WHERE p.product = :product AND p.isdelete =: isdelete AND p.startdatetime <=: startdatetime ORDER BY p.startdatetime DESC",
					Price.class).setParameter("product", new Product(productid))
					.setParameter("startdatetime", startdatetime).setParameter("isdelete", this.IS_NOT_DELETE)
					.setMaxResults(1).getSingleResult();
			return price.getPrice();
		} catch (Exception e) {
			return 0;
		}
	}

}