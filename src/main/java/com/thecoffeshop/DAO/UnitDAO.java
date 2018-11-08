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
public class UnitDAO implements UnitDAOImp {

	@Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean addUnit(Unit unit) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(unit);
			return true;
		} catch (Exception e) {
			return false;
		}
    }

    @Override
    public List<Unit> findAll() {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Unit>  units = session
                    .createQuery("FROM Unit u WHERE u.isdelete =: isdelete", Unit.class)
                    .setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return units;
		} catch (Exception e) {
			return null;
		}
    }

    @Override
    public Unit getInfoById(String unitid) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			Unit unit = session
                    .createQuery("FROM Unit u WHERE u.unitid =: unitid AND u.isdelete =: isdelete", Unit.class)
                    .setParameter("unitid",unitid).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return unit;
		} catch (Exception e) {
			return null;
		}
    }

    @Override
    public Boolean deleteUnit(String unitid) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
            Unit unit = this.getInfoById(unitid);
			session.remove(unit);
			return true;
		} catch (Exception e) {
			return false;
		}
    }

    @Override
    public Boolean editUnit(Unit unit) {
       
        Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(unit);
			return true;
		} catch (Exception e) {
			return false;
		}
}
}