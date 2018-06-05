package DAO.Impl;

import java.util.List;

import DAO.MajorDAO;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.MajorTbEntity;



public class MajorDAOImpl implements MajorDAO {
	private final SessionFactory sessionFactory; 
	 
	 
    public MajorDAOImpl() { 
       this.sessionFactory = new Configuration().configure().buildSessionFactory(); 
    }
    @Override
    public MajorTbEntity getMajorByID(int id) {
        String hql = "from MajorTbEntity s where s.majorId = ? "; 
       Query query = sessionFactory.getCurrentSession().createQuery(hql); 
       query.setParameter(0,id); 
        return (MajorTbEntity) query.uniqueResult(); 
    }



    @Override
    public List<MajorTbEntity> getMajorByName(String name) {
        String hql = "from MajorTbEntity m where m.majorName like ? ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,"%"+name+"%");
        return query.list();

    }

    @Override
    public List<MajorTbEntity> getAllMajor() { 
        String hql = "from MajorTbEntity order by majorId desc"; 
        Query query = sessionFactory.getCurrentSession().createQuery(hql); 
        return query.list(); 


    }

    @Override
    public void addMajor(MajorTbEntity major) { 
        sessionFactory.getCurrentSession().persist(major); 
    }

    @Override
    public void delMajor(int id) { 
       String hql = "delete from MajorTbEntity s where s.majorId = ?"; 
        Query query = sessionFactory.getCurrentSession().createQuery(hql); 
        query.setParameter(0,id); 
    }

    @Override
    public void updateMajor(MajorTbEntity major) { 
        sessionFactory.getCurrentSession().update(major); 
    } 
}
