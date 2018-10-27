package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Price;

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

}
