package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.ProductDAOImp;
import com.thecoffeshop.Models.Product;

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

}
