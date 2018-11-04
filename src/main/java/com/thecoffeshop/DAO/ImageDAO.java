package com.thecoffeshop.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Image;
import com.thecoffeshop.Models.Price;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class ImageDAO implements ImageDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Image> getListImageOfProduct(String PId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Image> images = session
					.createQuery("FROM Image p WHERE p.PId = :PId", Image.class)
					.setParameter("PId", PId).setParameter("is_delete", this.IS_NOT_DELETE).getResultList();
			
			return images;
		} catch (Exception e) {

			return null;
		}
	}

}
