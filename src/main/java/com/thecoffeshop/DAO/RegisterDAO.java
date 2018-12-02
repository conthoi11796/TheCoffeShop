package com.thecoffeshop.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.RegisterDAOImp;
import com.thecoffeshop.Models.Employee;
import com.thecoffeshop.Models.Register;

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
	public Register getInfoById(int registerid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Register register = session
					.createQuery("FROM Register r WHERE r.registerid = :registerid and r.isdelete =: isdelete",
							Register.class)
					.setParameter("registerid", registerid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return register;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Register> getListRegisterOnWeek(Date from, Date to) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Register> registers = session
					.createQuery("FROM Register r WHERE r.date >= :from AND r.date <= :to AND r.isdelete =: isdelete",
							Register.class)
					.setParameter("from", from).setParameter("to", to).setParameter("isdelete", this.IS_NOT_DELETE)
					.getResultList();
			return registers;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteRegister(Register register) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.remove(register);
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

	@Override
	public List<Register> listByDateScheduleid(Date date, String scheduleid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Register> registers = session.createQuery(
					"FROM Register r WHERE r.date = :date AND r.schedule.scheduleid = :scheduleid AND r.isdelete =: isdelete",
					Register.class).setParameter("date", date).setParameter("scheduleid", scheduleid)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return registers;

		} catch (Exception e) {

			return null;
		}
	}
}
