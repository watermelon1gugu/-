package DAO.Impl;

import java.util.List;

import DAO.MajorDAO;
import DAO.ManagerDAO;
import entity.MajorTbEntity;
import org.hibernate.Session;
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
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, "%" + name + "%");
        return query.list();
    }

    @Override
    public List<ManagerTbEntity> getAllManager() {
        String hql = "from ManagerTbEntity order by managerId desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();


    }

    @Override
    public void addManager(ManagerTbEntity manager) {
        sessionFactory.getCurrentSession().persist(manager);
    }

    @Override
    public void delManager(int id) {
        String hql = "delete from ManagerTbEntity s where s.managerId = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, id);
    }

    @Override
    public void updateManager(ManagerTbEntity manager) {
        sessionFactory.getCurrentSession().update(manager);
    }
}
