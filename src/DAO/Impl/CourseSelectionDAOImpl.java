package DAO.Impl;

import java.util.List;

import DAO.CourseSelectionDAO;
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
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, id);
        return (CourseSelectionTbEntity) query.uniqueResult();
    }

    @Override
    public List<CourseSelectionTbEntity> getAllCourseSelection() {
        String hql = "from CourseSelectionTbEntity order by stuCourseId desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void addCourseSelection(CourseSelectionTbEntity courseSelection) {
        sessionFactory.getCurrentSession().persist(courseSelection);
    }

    @Override
    public void delCourseSelection(int id) {
        String hql = "delete from CourseSelectionTbEntity s where s.stuCourseId = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, id);
    }

    @Override
    public void updateCourseSelection(CourseSelectionTbEntity courseSelection) {
        sessionFactory.getCurrentSession().update(courseSelection);
    }
    
}
