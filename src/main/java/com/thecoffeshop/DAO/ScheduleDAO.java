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
public class ScheduleDAO implements ScheduleDAOImp {

	@Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean addSchedule(Schedule schedule) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(schedule);
			return true;
		} catch (Exception e) {
			return false;
		}
    }

    @Override
    public List<Schedule> findAll() {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Schedule> schedules = session
					.createQuery("FROM Schedule s WHERE s.isdelete =: isdelete",
                    Schedule.class).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return schedules;
		} catch (Exception e) {
			return null;
		}
    }

    @Override
    public Schedule getInfoById(String scheduleid) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			Schedule schedule = session
					.createQuery("FROM Schedule s WHERE s.scheduleid =: scheduleid AND s.isdelete =: isdelete",
                    Schedule.class).setParameter("scheduleid",scheduleid).setParameter("isdelete", this.IS_NOT_DELETE)
					.getSingleResult();
			return schedule;
		} catch (Exception e) {
			return null;
		}
    }

    @Override
    public Boolean deleteSchedule(String scheduleid) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
            Schedule schedule = this.getInfoById(scheduleid);
			session.remove(schedule);
			return true;
		} catch (Exception e) {
			return false;
		}
    }

    @Override
    public Boolean editSchedule(Schedule schedule) {
        
        Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(schedule);
			return true;
		} catch (Exception e) {
			return false;
		}
    }
}