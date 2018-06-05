package DAO.Impl;

import DAO.StuDAO;
import entity.StuTbEntity;
import org.hibernate.SessionFactory;
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
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,id);
        return (StuTbEntity) query.uniqueResult();
    }

    @Override
    public List<StuTbEntity> getStuByName(String name) {
        String hql = "from StuTbEntity s where s.stuName like ? ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,"%"+name+"%");
        return query.list();
    }

    @Override
    public List<StuTbEntity> getAllStu() {
        String hql = "from StuTbEntity order by stuId desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();

    }

    @Override
    public void addStu(StuTbEntity stu) {
        sessionFactory.getCurrentSession().persist(stu);
    }

    @Override
    public void delStu(int id) {
        String hql = "delete from StuTbEntity s where s.stuId = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,id);
    }

    @Override
    public void updateStu(StuTbEntity stu) {
        sessionFactory.getCurrentSession().update(stu);
    }
}
