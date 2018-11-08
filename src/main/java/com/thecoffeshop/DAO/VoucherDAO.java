package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.thecoffeshop.DAOImp.VoucherDAOImp;
import com.thecoffeshop.Models.Price;
import com.thecoffeshop.Models.Voucher;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class VoucherDAO implements VoucherDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addVoucher(Voucher voucher) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(voucher);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	}

	@Override
	public List<Voucher> findAll() {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Voucher> vouchers = session
					.createQuery("FROM Voucher v WHERE  v.isdelete =: isdelete",
					Voucher.class).setParameter("isdelete", this.IS_NOT_DELETE)
					.getResultList();
			return vouchers;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Voucher findById(int voucherid) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Voucher voucher = session
					.createQuery("FROM Voucher v WHERE v.voucherid = :voucherid AND v.isdelete =: isdelete",
					Voucher.class)
					.setParameter("voucherid", voucherid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return voucher;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean checkVoucher(String voId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Voucher voucher= session
					.createQuery("FROM Voucher v WHERE v.voId = :voId AND v.isDelete =: is_delete", Voucher.class)
					.setParameter("voId", voId).setParameter("is_delete", this.IS_NOT_DELETE).getSingleResult();
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public Boolean deleteVoucher(int voucherid) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Voucher voucher =this.findById(voucherid);
			session.remove(voucher);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	}

	@Override
	public Boolean editVoucher(Voucher voucher) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(voucher);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	}

}
