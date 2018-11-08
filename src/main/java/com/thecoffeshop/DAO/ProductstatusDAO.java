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
public class ProductstatusDAO implements ProductstatusDAOImp {

	@Autowired
	private SessionFactory sessionFactory;

    @Override
    public Boolean addProductstatus(Productstatus productstatus) {
        
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.add(productstatus);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Productstatus> findAll() {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Productstatus> productstatus = session
                    .createQuery("FROM Productstatus p WHERE p.isdelete =: isdelete", Productstatus.class)
                    .setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return productstatus;
		} catch (Exception e) {
			return null;
		}
    }
  
    @Override
    public Productstatus getInfoById(int productstatusid) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			Productstatus productstatus = session
                    .createQuery("FROM Productstatus p WHERE productstatusid=:productstatusid AND p.isdelete =: isdelete", Productstatus.class)
                    .setParameter("productstatusid",productstatusid).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return productstatus;
		} catch (Exception e) {
			return null;
		}
    }

    @Override
    public Boolean deleteProductstatus(int productstatusid) {

        Session session = this.sessionFactory.getCurrentSession();
        try {
            Productstatus productstatus = this.getInfoById(productstatusid);
            session.remove(productstatus);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean editProductstatus(Productstatus productstatus) {
        
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.update(productstatus);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}