package DAO.Impl;

import java.util.List;

import DAO.DeptDAO;
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
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, id);
        return (DeptTbEntity) query.uniqueResult();
    }

    @Override
    public List<DeptTbEntity> getDeptByName(String name) {
        String hql = "from DeptTbEntity d where d.deptName like ? ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,"%"+name+"%");
        return query.list();
    }

    @Override
    public List<DeptTbEntity> getAllDept() {
        String hql = "from DeptTbEntity order by deptId desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();


    }

    @Override
    public void addDept(DeptTbEntity dept) {
        sessionFactory.getCurrentSession().persist(dept);
    }

    @Override
    public void delDept(int id) {
        String hql = "delete from DeptTbEntity s where s.deptId = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, id);
    }

    @Override
    public void updateDept(DeptTbEntity dept) {
        sessionFactory.getCurrentSession().update(dept);
    }
}
