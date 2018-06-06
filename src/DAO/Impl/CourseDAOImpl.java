package DAO.Impl;

import java.util.List;

import DAO.CourseDAO;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.CourseTbEntity;

public class CourseDAOImpl implements CourseDAO {

    private final SessionFactory sessionFactory;

    public CourseDAOImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public CourseTbEntity getCourseByID(int id) {
        String hql = "from CourseTbEntity s where s.courseId = ? ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, id);
        return (CourseTbEntity) query.uniqueResult();
    }

    @Override
    public List<CourseTbEntity> getCourseByName(String name) {
        String hql = "from CourseTbEntity c where c.courseName like ? ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,"%"+name+"%");
        return query.list();
    }

    @Override
    public List<CourseTbEntity> getAllCourse() {
        String hql = "from CourseTbEntity order by courseId desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }


    @Override
    public void addCourse(CourseTbEntity course) {
        sessionFactory.getCurrentSession().persist(course);
    }

    @Override
    public void delCourse(int id) {
        String hql = "delete from CourseTbEntity s where s.courseId = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, id);
    }

    @Override
    public void updateCourse(CourseTbEntity course) {
        sessionFactory.getCurrentSession().update(course);
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
