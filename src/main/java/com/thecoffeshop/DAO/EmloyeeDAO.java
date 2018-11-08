package com.thecoffeshop.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.Models.*;
import com.thecoffeshop.DAOImp.*;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class EmloyeeDAO implements EmployeeDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> findAll(int start, int numberRow) {
		Session session = this.sessionFactory.getCurrentSession();
		return session
				.createQuery("FROM Employee e WHERE e.isdelete =: isdelete LIMIT :start,:numberRow", Employee.class)
				.setParameter("is_delete", this.IS_NOT_DELETE).setParameter("start", start)
				.setParameter("numberRow", numberRow).getResultList();
	}

	@Override
	public Boolean addEmployee(Employee employee) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String logIn(String username, String password) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Employee employee = session.createQuery(
					"FROM Employee e WHERE e.usename = :username AND e.password = :password AND e.isdelete =: isdelete",
					Employee.class).setParameter("username", username).setParameter("password", password)
					.setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return employee.getEmployeeid();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public Employee getInfoById(String emId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			Employee employee = session
					.createQuery("FROM Employee e WHERE e.employeeid = :employeeid and e.isdelete =: isdelete", Employee.class)
					.setParameter("employeeid", emId).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return employee;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean deleteEmployee(String employeeid) {
		

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Employee employee = this.getInfoById(employeeid);
			session.remove(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean editEmployee(Employee employee) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	

//public void save(Employee employee) {
//	Session session = this.sessionFactory.getCurrentSession();
//	session.save(employee);
//}
//
//public void update(Customer customer) {
//	Session session = this.sessionFactory.getCurrentSession();
//	session.update(customer);
//}
//
//public Customer findById(final int id) {
//	Session session = this.sessionFactory.getCurrentSession();
//	return session.get(Customer.class, id);
//}
//
//public void delete(final Customer customer) {
//	Session session = this.sessionFactory.getCurrentSession();
//	session.remove(customer);
//}
//
}
