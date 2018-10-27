package com.thecoffeshop.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Categoryproduct;
import com.thecoffeshop.Models.Employee;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class CategoryProductDAO implements CategoryProductDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Categoryproduct> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Categoryproduct> liCategoryproducts = session
					.createQuery("FROM Categoryproduct c where c.isDelete = :is_delete", Categoryproduct.class)
					.setParameter("is_delete", this.IS_NOT_DELETE).getResultList();
			return liCategoryproducts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean addCategoryProduct(Categoryproduct categoryproduct) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(categoryproduct);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Categoryproduct getInfoById(String cgPrdId) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {

			Categoryproduct categoryproduct= session
					.createQuery("FROM Categoryproduct cp WHERE cp.cgPrdId = :cgPrdId and cp.isDelete =: is_delete", Categoryproduct.class)
					.setParameter("cgPrdId", cgPrdId).setParameter("is_delete", this.IS_NOT_DELETE).getSingleResult();
			return categoryproduct;
		} catch (Exception e) {

			return null;
		}
	}

}
