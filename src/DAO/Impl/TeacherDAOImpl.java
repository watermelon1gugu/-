package DAO.Impl;

import java.util.List;

import DAO.TeacherDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        TeacherTbEntity teacherTbEntity =  (TeacherTbEntity) query.uniqueResult();
        session.close();
        return teacherTbEntity;
    }

    @Override
    public List<TeacherTbEntity> getTeacherByName(String name) {
        String hql = "from TeacherTbEntity t where t.teacherName like ? ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,"%"+name+"%");
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<TeacherTbEntity> getAllTeacher() {
        String hql = "from TeacherTbEntity order by teacherId desc";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;


    }

    @Override
    public void addTeacher(TeacherTbEntity teacher) {
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.persist(teacher);
        transaction.commit();
        session.close();
    }

    @Override
    public void delTeacher(int id) {
        String hql = "delete from TeacherTbEntity s where s.teacherId = ?";
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateTeacher(TeacherTbEntity teacher) {
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.update(teacher);
        transaction.commit();
        session.close();
    }
}
