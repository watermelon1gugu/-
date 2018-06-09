package DAO.Impl;

import java.util.List;

import DAO.MajorDAO;
import DAO.ManagerDAO;
import entity.MajorTbEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.ManagerTbEntity;

public class ManagerDAOImpl implements ManagerDAO {
    private final SessionFactory sessionFactory;


    public ManagerDAOImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public ManagerTbEntity getManagerByID(int id) {
        String hql = "from ManagerTbEntity s where s.managerId = ? ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        ManagerTbEntity managerTbEntity = (ManagerTbEntity) query.uniqueResult();
        session.close();
        return managerTbEntity;
    }

    @Override
    public List<ManagerTbEntity> getManagerByName(String name) {
        String hql = "from ManagerTbEntity m where m.managerName like ? ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, "%" + name + "%");
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<ManagerTbEntity> getAllManager() {
        String hql = "from ManagerTbEntity order by managerId desc";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;


    }

    @Override
    public void addManager(ManagerTbEntity manager) {
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.persist(manager);
        transaction.commit();
        session.close();
    }

    @Override
    public void delManager(int id) {
        String hql = "delete from ManagerTbEntity s where s.managerId = ?";
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateManager(ManagerTbEntity manager) {
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        sessionFactory.getCurrentSession().update(manager);
        transaction.commit();
        session.close();
    }
}
