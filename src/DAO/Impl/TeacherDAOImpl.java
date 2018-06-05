package DAO.Impl;

import java.util.List;

import DAO.TeacherDAO;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.TeacherTbEntity;

public class TeacherDAOImpl implements TeacherDAO {
    private final SessionFactory sessionFactory;

    public TeacherDAOImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public TeacherTbEntity getTeacherByID(int id) {
        String hql = "from TeacherTbEntity s where s.teacherId = ? ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, id);
        return (TeacherTbEntity) query.uniqueResult();
    }

    @Override
    public List<TeacherTbEntity> getTeacherByName(String name) {
        String hql = "from TeacherTbEntity t where t.teacherName like ? ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,"%"+name+"%");
        return query.list();
    }

    @Override
    public List<TeacherTbEntity> getAllTeacher() {
        String hql = "from TeacherTbEntity order by teacherId desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();


    }

    @Override
    public void addTeacher(TeacherTbEntity teacher) {
        sessionFactory.getCurrentSession().persist(teacher);
    }

    @Override
    public void delTeacher(int id) {
        String hql = "delete from TeacherTbEntity s where s.teacherId = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, id);
    }

    @Override
    public void updateTeacher(TeacherTbEntity teacher) {
        sessionFactory.getCurrentSession().update(teacher);
    }
}
