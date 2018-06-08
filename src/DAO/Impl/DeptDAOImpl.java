package DAO.Impl;

import java.util.List;

import DAO.DeptDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.DeptTbEntity;

public class DeptDAOImpl implements DeptDAO {
    private final SessionFactory sessionFactory;


    public DeptDAOImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public DeptTbEntity getDeptByID(int id) {
        String hql = "from DeptTbEntity s where s.deptId = ? ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        DeptTbEntity deptTbEntity = (DeptTbEntity) query.uniqueResult();
        session.close();
        return deptTbEntity;
    }

    @Override
    public List<DeptTbEntity> getDeptByName(String name) {
        String hql = "from DeptTbEntity d where d.deptName like ? ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,"%"+name+"%");
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<DeptTbEntity> getAllDept() {
        String hql = "from DeptTbEntity order by deptId desc";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;


    }

    @Override
    public void addDept(DeptTbEntity dept) {
        Session session = sessionFactory.openSession();
        session.persist(dept);
        session.close();
    }

    @Override
    public void delDept(int id) {
        String hql = "delete from DeptTbEntity s where s.deptId = ?";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        session.close();
    }

    @Override
    public void updateDept(DeptTbEntity dept) {
        Session session = sessionFactory.openSession();
        session.update(dept);
        session.close();
    }

}
