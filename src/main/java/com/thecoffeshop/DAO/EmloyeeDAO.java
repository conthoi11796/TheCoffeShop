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
	public String logIn(String username, String password) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Employee employee = session.createQuery(
					"FROM Employee e WHERE e.emUsername = :username and e.emPassword = :password and e.isDelete =: is_delete",
					Employee.class).setParameter("username", username).setParameter("password", password)
					.setParameter("is_delete", this.IS_NOT_DELETE).getSingleResult();
			return employee.getEmId();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public Employee getInfoById(String emId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			Employee employee = session
					.createQuery("FROM Employee e WHERE e.emId = :emId and e.isDelete =: is_delete", Employee.class)
					.setParameter("emId", emId).setParameter("is_delete", this.IS_NOT_DELETE).getSingleResult();
			return employee;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Employee> findAll(int start, int numberRow) {
		Session session = this.sessionFactory.getCurrentSession();
		return session
				.createQuery("FROM Employee e WHERE e.isDelete =: is_delete LIMIT :start,:numberRow", Employee.class)
				.setParameter("is_delete", this.IS_NOT_DELETE).setParameter("start", start)
				.setParameter("numberRow", numberRow).getResultList();
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
