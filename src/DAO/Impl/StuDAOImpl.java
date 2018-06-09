package DAO.Impl;

import DAO.StuDAO;
import entity.StuTbEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class StuDAOImpl implements StuDAO {
    private final SessionFactory sessionFactory;

    public StuDAOImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public StuTbEntity getStuByID(int id) {
        String hql = "from StuTbEntity s where s.stuId = ? ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,id);
        StuTbEntity stuTbEntity = (StuTbEntity) query.uniqueResult();
        session.close();
        return stuTbEntity;
    }

    @Override
    public List<StuTbEntity> getStuByName(String name) {
        String hql = "from StuTbEntity s where s.stuName like ? ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,"%"+name+"%");
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<StuTbEntity> getAllStu() {
        String hql = "from StuTbEntity order by stuId desc";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;

    }

    @Override
    public void addStu(StuTbEntity stu) {
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.persist(stu);
        transaction.commit();
        session.close();
    }

    @Override
    public void delStu(int id) {
        String hql = "delete from StuTbEntity s where s.stuId = ?";
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter(0,id);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateStu(StuTbEntity stu) {
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.update(stu);
        transaction.commit();
        session.close();
    }
}
