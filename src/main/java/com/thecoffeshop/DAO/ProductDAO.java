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
	public List<Product> getListProductLimit(int startPosition, String categoryproductid, String strSearch,
			String isHotDeal, String priceAZ, String priceZA) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			String hql = "FROM Product p WHERE p.isdelete =: isdelete";
			if (categoryproductid != null) {
				hql = hql + " AND p.categoryproduct =: categoryproduct ";
			}
			if (strSearch != null) {
				System.out.println("xxx");
				hql = hql + " AND p.name = :name ";
			}
//			if (isHotDeal) {
//				hql = hql + " AND p.categoryproduct =: categoryproduct ";
//			}
//			if (priceAZ) {
//				hql = hql + " ORDER BY ASC ";
//			}
//			if (priceZA) {
//				hql = hql + " ORDER BY DESC ";
//			}
			Query query = session.createQuery(hql, Product.class);
			query.setParameter("isdelete", this.IS_NOT_DELETE);
			if (categoryproductid != null) {
				query.setParameter("categoryproduct", new Categoryproduct(categoryproductid));
			}
			if (strSearch != null) {
				query.setParameter("name", "%" + strSearch + "%");
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

	@Override
	public List<Product> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Product> products = session.createQuery("FROM Product p WHERE p.isdelete =: isdelete", Product.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return products;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean checkExistNameProduct(String name) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Product products = session
					.createQuery("FROM Product p WHERE p.name =: name AND p.isdelete =: isdelete", Product.class)
					.setParameter("name", name).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean checkExistCategoryProduct(String categoryproductid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Product> products = session
					.createQuery("FROM Product p WHERE p.categoryproduct = :categoryproduct and p.isdelete =: isdelete",
							Product.class)
					.setParameter("categoryproduct", new Categoryproduct(categoryproductid))
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			if (products.size() > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Product> findLimit(int startPosition) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Product> products = session.createQuery("FROM Product p WHERE p.isdelete =: isdelete", Product.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).setFirstResult(startPosition * MAX_RESULTS)
					.setMaxResults(MAX_RESULTS).getResultList();
			return products;
		} catch (Exception e) {
			return null;
		}
	}
}
