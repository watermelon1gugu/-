package DAO.Impl;

import java.util.List;

import DAO.CourseSelectionDAO;
import entity.CourseSelectionTbEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CourseSelectionDAOImpl implements CourseSelectionDAO {
    private final SessionFactory sessionFactory;


    public CourseSelectionDAOImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public CourseSelectionTbEntity getCourseSelectionByID(int id) {
        String hql = "from CourseSelectionTbEntity s where s.stuCourseId = ? ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        CourseSelectionTbEntity courseSelectionTbEntity = (CourseSelectionTbEntity) query.uniqueResult();
        session.close();
        return courseSelectionTbEntity;
    }

    @Override
    public List<CourseSelectionTbEntity> getAllCourseSelection() {
        String hql = "from CourseSelectionTbEntity order by stuCourseId desc";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public void addCourseSelection(CourseSelectionTbEntity courseSelection) {
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.persist(courseSelection);
        transaction.commit();
        session.close();
    }

    @Override
    public void delCourseSelection(int id) {
        String hql = "delete from CourseSelectionTbEntity s where s.stuCourseId = ?";
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void updateCourseSelection(CourseSelectionTbEntity courseSelection) {
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.update(courseSelection);
        transaction.commit();
        session.close();
    }
    
}
