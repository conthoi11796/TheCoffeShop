package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.VoucherDAOImp;
import com.thecoffeshop.Models.Price;
import com.thecoffeshop.Models.Voucher;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class VoucherDAO implements VoucherDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

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

}
