package com.thecoffeshop.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Price;
import com.thecoffeshop.Models.Product;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class PriceDAO implements PriceDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addPrice(Price price) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(price);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Price getInfoById(String prId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Price price = session
					.createQuery("FROM Price p WHERE p.prId = :prId AND p.isDelete =: is_delete", Price.class)
					.setParameter("prId", prId).setParameter("is_delete", this.IS_NOT_DELETE).getSingleResult();
			return price;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Price getInfoByProduct(String PId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Price Price = session.createQuery(
					"FROM Price p WHERE p.product = :product AND p.isDelete =: is_delete ORDER BY p.prDatestart > now()",
					Price.class).setParameter("product", new Product(PId)).setParameter("is_delete", this.IS_NOT_DELETE)
					.getSingleResult();
			return Price;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Price getNewPrice(String PId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Price price = session.createQuery(
					"FROM Price p WHERE p.product = :product AND p.isDelete =: is_delete AND p.prDatestart > now()",
					Price.class).setParameter("product", new Product(PId)).setParameter("is_delete", this.IS_NOT_DELETE)
					.setMaxResults(1).getSingleResult();
			return price;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int getOldPrice(String PId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Price price = session.createQuery(
					"FROM Price p WHERE p.product = :product AND p.isDelete =: is_delete AND p.prDatestart <= now() ORDER BY p.prDatestart DESC",
					Price.class).setParameter("product", new Product(PId)).setParameter("is_delete", this.IS_NOT_DELETE)
					.setMaxResults(1).getSingleResult();
			return price.getPrPrice();
		} catch (Exception e) {
			return 0;
		}
	}
}
