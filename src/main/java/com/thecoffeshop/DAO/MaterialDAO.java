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
public class MaterialDAO implements MaterialDAOImp {

	@Autowired 
    private SessionFactory sessionFactory;

    @Override
    public Boolean addAtposition(Material material) {

        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.add(material);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Material> findAll() {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {

			List<Material> materials = session
                    .createQuery("FROM Material m WHERE m.isdelete =: isdelete", Material.class)
                    .setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return materials;
		} catch (Exception e) {

			return null;
		}
    }

    @Override
    public Material getInfoById(int materialid) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			Material material = session
                    .createQuery("FROM Material m WHERE materialid=: materialid AND m.isdelete =: isdelete", Material.class)
                    .setParameter("materialid", materialid).setParameter("isdelete", this.IS_NOT_DELETE).getSingleResult();
			return material;
		} catch (Exception e) {
			return null;
		}
    }

    @Override
    public Boolean deleteAtposition(int materialid) {
        
        Session session = this.sessionFactory.getCurrentSession();
        try {
            Material material = this.getInfoById(materialid);
            session.remove(material);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean editAtposition(Material material) {
        
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.update(material);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}