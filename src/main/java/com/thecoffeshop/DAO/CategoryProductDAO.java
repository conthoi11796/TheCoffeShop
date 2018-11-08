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
	public List<Categoryproduct> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Categoryproduct> liCategoryproducts = session
					.createQuery("FROM Categoryproduct c where c.isdelete = :isdelete", Categoryproduct.class)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return liCategoryproducts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Categoryproduct getInfoById(String categoryproductid) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {

			Categoryproduct categoryproduct= session
					.createQuery("FROM Categoryproduct cp WHERE cp.categoryproductid = :categoryproductid and cp.isdelete =: isdelete", Categoryproduct.class)
					.setParameter("categoryproductid", categoryproductid).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return categoryproduct;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteCategoryproduct(String categoryproductid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Categoryproduct categoryproduct = this.getInfoById(categoryproductid);
			if(categoryproduct != null){
				if(session.delete(categoryproduct)){
					return true;
				}
				return false;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editCategoryproduct(String cgPrcategoryproductiddId) {
		return null;
	}

}
