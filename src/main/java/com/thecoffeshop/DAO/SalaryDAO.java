package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class SalaryDAO implements SalaryDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addSalary(Salary salary) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(salary);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Salary getInfoById(int dinnertableid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Salary salary = session
					.createQuery("FROM Salary s WHERE s.dinnertableid = :dinnertableid and s.isdelete =: isdelete",
							Salary.class)
					.setParameter("dinnertableid", dinnertableid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return salary;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteSalary(int dinnertableid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Salary salary = this.getInfoById(dinnertableid);
			session.remove(salary);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editSalary(Salary salary) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(salary);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int getSalaryByEmployeeid(String employeeid) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Salary salary = session
					.createQuery("FROM Salary s WHERE s.employees = :employees AND s.isdelete =: isdelete ORDER BY s.createat DESC",
							Salary.class)
					.setParameter("employees", new Employee(employeeid)).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return salary.getSalaryonhour();
		} catch (Exception e) {

			return 0;
		}
	}

}