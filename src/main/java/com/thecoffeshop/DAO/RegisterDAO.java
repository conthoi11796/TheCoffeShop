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

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class RegisterDAO implements RegisterDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addRegister(Register register) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(register);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Register getInfoById(RegisterId registerId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Register register = session
					.createQuery("FROM Register r WHERE r.registerId = :registerId and r.isdelete =: isdelete",
							Register.class)
					.setParameter("registerId", registerId).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return register;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Register> getListRegisterOnWeek(int moth) {

		return null;
	}

	@Override
	public Boolean deleteRegister(RegisterId registerId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.remove(registerId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editRegister(Register register) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(register);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean checkExistSchedule(String scheduleid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			return true;
		} catch (Exception e) {

			return null;
		}
	}
}
