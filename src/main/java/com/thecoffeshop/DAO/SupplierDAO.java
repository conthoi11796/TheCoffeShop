package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;
@Repository()
@Transactional(rollbackFor = Exception.class)
public class SupplierDAO implements SupplierDAOImp {

	@Autowired 
    private SessionFactory sessionFactory;

    @Override
    public Boolean addSupplier(Supplier supplier) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}
    }

    @Override
    public List<Supplier> findAll() {

        Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Supplier> suppliers = session
                    .createQuery("FROM Supplier s WHERE s.isdelete =: isdelete", Supplier.class)
                    .setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return suppliers;
		} catch (Exception e) {

			return null;
		}
    }

    @Override
    public Supplier getInfoById(int supplierid) {
       
        Session session = this.sessionFactory.getCurrentSession();
		try {
			Supplier supplier = session
					.createQuery("FROM Supplier s WHERE s.supplierid =: supplierid AND p.isdelete =: isdelete", Supplier.class)
					.setParameter("supplierid", supplierid).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return supplier;
		} catch (Exception e) {

			return null;
		}
    }

    @Override
    public Boolean deleteSupplier(int supplierid) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
            Supplier supplier = this.getInfoById(supplierid);
			session.remove(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}
    }

    @Override
    public Boolean editSupplier(Supplier supplier) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}
    }

}