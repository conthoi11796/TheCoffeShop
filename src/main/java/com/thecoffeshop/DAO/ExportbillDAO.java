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
public class ExportbillDAO implements ExportbillDAOImp {

	@Autowired 
    private SessionFactory sessionFactory;

    @Override
    public Boolean addExportbill(Exportbill exportbill) {

        Session session = this.sessionFactory.getCurrentSession();
		try {
            session.save(exportbill);
            return true;
		} catch (Exception e) {
			return false;
		}
    }

    @Override
    public List<Exportbill> findAll() {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {

			List<Exportbill> exportbills = session
                    .createQuery("FROM Exportbill e WHERE e.isdelete =: isdelete", Exportbill.class)
                    .setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return exportbills;
		} catch (Exception e) {

			return null;
		}
    }

    @Override
    public Exportbill getInfoById(int exportbillid) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {

			Exportbill exportbill = session
                    .createQuery("FROM Exportbill e WHERE e.exportbillid =: exportbillid AND e.isdelete =: isdelete", Exportbill.class)
                    .setParameter("exportbillid", exportbillid).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return exportbill;
		} catch (Exception e) {

			return null;
		}
    }

    @Override
    public Boolean deleteExportbill(int exportbillid) {
        
        Session session = this.sessionFactory.getCurrentSession();
        try {
            Exportbill exportbill = this.getInfoById(exportbillid);
            session.remove(exportbill);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean editExportbill(Exportbill exportbill) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.update(exportbill);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}