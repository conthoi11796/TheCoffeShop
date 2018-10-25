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
	public Employee logIn(String username, String password) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			
			Employee employee = session.createQuery(
					"FROM Employee e where e.emUsername = :username and e.emPassword = :password and e.isDelete =: is_delete",
					Employee.class).setParameter("username", username).setParameter("password", password)
					.setParameter("is_delete", this.IS_NOT_DELETE).getSingleResult();
			return employee;
		} catch (Exception e) {
			
			return null;
		}

	}

//	public void save(Employee employee) {
//		Session session = this.sessionFactory.getCurrentSession();
//		session.save(employee);
//	}
//
//	public void update(Customer customer) {
//		Session session = this.sessionFactory.getCurrentSession();
//		session.update(customer);
//	}
//
//	public Customer findById(final int id) {
//		Session session = this.sessionFactory.getCurrentSession();
//		return session.get(Customer.class, id);
//	}
//
//	public void delete(final Customer customer) {
//		Session session = this.sessionFactory.getCurrentSession();
//		session.remove(customer);
//	}
//
	public List<Employee> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Employee", Employee.class).getResultList();
	}
}
