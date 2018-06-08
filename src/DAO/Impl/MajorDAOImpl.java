package DAO.Impl;

import java.util.List;

import DAO.MajorDAO;
import org.hibernate.Session;
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
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,id);
        MajorTbEntity majorTbEntity = (MajorTbEntity) query.uniqueResult();
        session.close();
        return majorTbEntity;
    }



    @Override
    public List<MajorTbEntity> getMajorByName(String name) {
        String hql = "from MajorTbEntity m where m.majorName like ? ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,"%"+name+"%");
        List list = query.list();
        session.close();
        return list;

    }

    @Override
    public List<MajorTbEntity> getAllMajor() { 
        String hql = "from MajorTbEntity order by majorId desc";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;


    }

    @Override
    public void addMajor(MajorTbEntity major) {
        Session session = sessionFactory.openSession();
        session.persist(major);
        session.close();
    }

    @Override
    public void delMajor(int id) { 
       String hql = "delete from MajorTbEntity s where s.majorId = ?";
       Session session = sessionFactory.openSession();
       Query query = session.createQuery(hql);
       query.setParameter(0,id);
       session.close();
    }

    @Override
    public void updateMajor(MajorTbEntity major) {
        Session session = sessionFactory.openSession();
        session.update(major);
    } 
}
