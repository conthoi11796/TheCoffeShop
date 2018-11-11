package com.thecoffeshop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.Bill;
import com.thecoffeshop.Models.Dinnertable;
import com.thecoffeshop.Models.Position;
@Repository()
@Transactional(rollbackFor = Exception.class)
public class PositionDAO implements PositionDAOImp {

	@Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean addPosition(Position position) {
        
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.save(position);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Position> findAll() {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {

			List<Position> positions = session
                    .createQuery("FROM Position p WHERE p.isdelete =: isdelete", Position.class)
                    .setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return positions;
		} catch (Exception e) {

			return null;
		}
    }

    @Override
    public Position getInfoById(String positionid) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {

			Position position = session
                    .createQuery("FROM Position p WHERE p.positionid =:positionid AND p.isdelete =: isdelete", Position.class)
                    .setParameter("positionid",positionid).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return position;
		} catch (Exception e) {

			return null;
		}
    }

    @Override
    public Boolean deletePosition(String positionid) {

        Session session = this.sessionFactory.getCurrentSession();
		try {
            Position position =this.getInfoById(positionid);
            session.remove(position);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean editPosition(Position position) {

        Session session = this.sessionFactory.getCurrentSession();
		try {
            session.update(position);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

	@Override
	public Position getInfoByName(String name) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {

			Position position = session
                    .createQuery("FROM Position p WHERE p.name =:name AND p.isdelete =: isdelete", Position.class)
                    .setParameter("name",name).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return position;
		} catch (Exception e) {

			return null;
		}
	}

}