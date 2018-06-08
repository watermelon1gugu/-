package DAO.Impl;

import java.util.List;

import DAO.CourseDAO;
import org.hibernate.Session;
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
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        CourseTbEntity courseTbEntity =  (CourseTbEntity) query.uniqueResult();
        session.close();
        return courseTbEntity;
    }

    @Override
    public List<CourseTbEntity> getCourseByName(String name) {
        String hql = "from CourseTbEntity c where c.courseName like ? ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,"%"+name+"%");
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<CourseTbEntity> getAllCourse() {
        String hql = "from CourseTbEntity order by courseId desc";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }


    @Override
    public void addCourse(CourseTbEntity course) {
        Session session = sessionFactory.openSession();
        session.persist(course);
        session.close();
    }

    @Override
    public void delCourse(int id) {
        String hql = "delete from CourseTbEntity s where s.courseId = ?";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        session.close();
    }

    @Override
    public void updateCourse(CourseTbEntity course) {
        Session session = sessionFactory.openSession();
        session.update(course);
        session.close();
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
