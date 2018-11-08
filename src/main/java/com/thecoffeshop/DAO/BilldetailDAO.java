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
public class BilldetailDAO implements BilldetailDAOImp {

	@Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean addBilldetail(Billdetail billdetail) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
            if(session.save(billdetail)){

                return true;
            }
            return false
		} catch (Exception e) {
			return false;
		}
    }

    @Override
    public List<Billdetail> getInfoBilldetailByBillId(int billid) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Billdetail> billdetails = session
					.createQuery("FROM Billdetail b WHERE b.BilldetailId =:billdetailId AND b.isdelete =: isdelete",
					Billdetail.class).setParameter("billdetailId", new BilldetailId( null, billid)).setParameter("isdelete", this.IS_NOT_DELETE)
					.getResultList();
			return billdetails;
		} catch (Exception e) {

			return null;
		}
    }

    @Override
    public Billdetail getInfoBilldetailByBilldetailId(BilldetailId billdetailId) {
        
        Session session = this.sessionFactory.getCurrentSession();
        try {
            Billdetail billdetail =  session.createQuery("FROM Billdetail b WHERE b.BilldetailId =:billdetailId AND b.isdelete =: isdelete",
            Billdetail.class).setParameter("billdetailId", billdetailId).setParameter("isdelete", this.IS_NOT_DELETE)
            .getSingleList();
            return billdetail;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean deleteBilldetail(BilldetailId billdetailId) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
            Billdetail billdetail = this.getInfoBilldetailByBilldetailId(billdetailId);
            if(billdetail!=null){
                if(session.delete(billdetail)){
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean editBilldetail(Billdetail billdetail) {
        return null;
    }


}