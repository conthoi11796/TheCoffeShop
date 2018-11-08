package com.thecoffeshop.DAO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.ProductDAOImp;
import com.thecoffeshop.Models.*;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class ProductDAO implements ProductDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addProduct(Product product) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Product getInfoById(String productid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Product product = session
					.createQuery("FROM Product p WHERE p.productid = :productid and p.isdelete =: isdelete",
							Product.class)
					.setParameter("productid", productid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return product;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Product> getListProductLimit(int startPosition, String categoryproductid, String strSearch) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			String hql = "FROM Product p WHERE p.isdelete =: isdelete";
			if (categoryproductid != null) {
				hql = hql + " AND p.categoryproduct =:categoryproduct ";
			}
			Query query = session.createQuery(hql, Product.class);
			query.setParameter("isdelete", this.IS_NOT_DELETE);
			if (categoryproductid != null) {
				query.setParameter("categoryproduct", new Categoryproduct(categoryproductid));
			}
			query.setFirstResult(startPosition * NUM_PRODUCT_ONE_PAGE);
			query.setMaxResults(NUM_PRODUCT_ONE_PAGE);
			List<Product> products = query.getResultList();
			return products;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean checkIsNewProduct(String productid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Product product = session
					.createQuery("FROM Product p WHERE p.productid = :productid and p.isdelete =: isdelete",
							Product.class)
					.setParameter("productid", productid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(product.getCreateat());
			c2.setTime(new Date());

			long numDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
			if (numDay <= 7) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public Boolean deleteProduct(String productid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Product product = this.getInfoById(productid);
			session.remove(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editProduct(Product product) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
